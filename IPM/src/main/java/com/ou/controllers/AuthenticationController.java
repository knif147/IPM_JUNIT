package com.ou.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ou.authentication.CustomUserDetails;
import com.ou.entity.User;
import com.ou.services.UserService;
import com.ou.utils.Constant;

@Controller
public class AuthenticationController {
	public static final String ACCOUNT_ATTRIBUTE = "account";
	public static final String REQUESTED_URL = "REQUESTED_URL";

	@Autowired
	UserService userService;

	@GetMapping(value = { "/login", "/", "home" })
	public String login() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session)
			throws AuthenticationException {
		User user = this.userService.login(username, password);
		String url = (String) session.getAttribute(REQUESTED_URL);
		session.removeAttribute(REQUESTED_URL); // Remove the attribute
		if (StringUtils.hasText(url) && !url.contains("login")) { // Prevent loops for the login page.
			return "redirect:" + url;
		} else {
			return "redirect:/index.htm";
		}
	}

	@GetMapping(value = "/loginSuccess")
	public String loginSuccess() {
		String redirect = "";

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User currentUser = ((CustomUserDetails) principal).getUser();
		int role = currentUser.getRole();
		switch (role) {
		case Constant.ROLE.ADMIN:
			redirect = "redirect:/admin/hr";
			break;
		case Constant.ROLE.HR:
			redirect = "redirect:/hr/recruiment/group";
			break;
		case Constant.ROLE.INTERVIEWER:
			redirect = "redirect:/interviewer/interview";
			break;
		default:
			break;
		}

		return redirect;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
}
