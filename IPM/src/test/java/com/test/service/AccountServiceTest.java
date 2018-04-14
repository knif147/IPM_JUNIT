package com.test.service;
import static junit.framework.Assert.assertEquals;

import org.apache.http.auth.AuthenticationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ou.entity.Account;
import com.ou.repository.AccountRepository;
import com.ou.services.AccountService;
import com.ou.services.AccountServiceImpl;
import com.ou.support.AccountBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setup() {
        Account account = new AccountBuilder() {
            {
                address("Herve", "4650", "Rue de la gare", "1", null, "Belgium");
                credentials("john", "secret");
                name("John", "Doe");
            }
        }.build(true);

        Mockito.when(accountRepository.findByUsername("john")).thenReturn(account);
    }

    @After
    public void verify() {
        Mockito.verify(accountRepository, VerificationModeFactory.times(1)).findByUsername(Mockito.anyString());
        // This is allowed here: using container injected mocks
        Mockito.reset(accountRepository);
    }

    @Test(expected = AuthenticationException.class)
    public void testLoginFailure() throws AuthenticationException {
        accountService.login("john", "fail");
    }

    @Test()
    public void testLoginSuccess() throws AuthenticationException {
        Account account = accountService.login("john", "secret");
        assertEquals("John", account.getFirstName());
        assertEquals("Doe", account.getLastName());
    }

    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }

        @Bean
        public AccountRepository accountRepository() {
            return Mockito.mock(AccountRepository.class);
        }
    }
}