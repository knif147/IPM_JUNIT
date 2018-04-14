package com.test.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ou.controllers.AuthenticationController;
import com.ou.entity.User;
import com.ou.services.UserService;
import com.ou.support.UserBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LoginControllerTest {
	@Autowired
	private AuthenticationController authenticationController;
	@Autowired
	UserService userService;

	@Before
	public void setup() throws AuthenticationException {
		User user = new UserBuilder() {
			{
				credentials("kien", "TranTrung", "01636507052", "kiencaothang@gmail.com", "123456789", 1, true, true,
						"daskhdsajgdkjsahdkjsad");

			}
		}.build(true);

		Mockito.when(this.userService.findById(0)).thenReturn(user);
	}

	@After
	public void verify() throws AuthenticationException {
		Mockito.verify(this.userService, VerificationModeFactory.times(3)).findById(0);
		Mockito.reset();
	}

	@Test
	public void testHandleLogin() throws AuthenticationException {

		MockHttpSession mockHttpSession = new MockHttpSession();
		mockHttpSession.setAttribute(AuthenticationController.REQUESTED_URL, "someUrl");

		String view = this.authenticationController.handleLogin("kien", "123456789", mockHttpSession);

		User user = (User) mockHttpSession.getAttribute(AuthenticationController.ACCOUNT_ATTRIBUTE);

		assertNotNull(user);
		assertEquals("Kien", user.getUserName());
		assertEquals("TranTrung", user.getFullName());
		assertNull(mockHttpSession.getAttribute(AuthenticationController.REQUESTED_URL));
		assertEquals("redirect:someUrl", view);

		// Test the different view selection choices
		mockHttpSession = new MockHttpSession();
		view = this.authenticationController.handleLogin("kien", "trantrung", mockHttpSession);
		assertEquals("redirect:/index.htm", view);

		mockHttpSession = new MockHttpSession();
		mockHttpSession.setAttribute(AuthenticationController.REQUESTED_URL, "abclogindef");
		view = this.authenticationController.handleLogin("john", "secret", mockHttpSession);
		assertEquals("redirect:/index.htm", view);
	}

	@Configuration
	static class LoginControllerTestConfiguration {

		@Bean
		public UserService userService() {
			return Mockito.mock(UserService.class);
		}

		@Bean
		public AuthenticationController authenticationController() {
			return new AuthenticationController();
		}
	}

}
