package com.ou.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ou.entity.User;
import com.ou.services.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	
	public boolean supports(Class<?> cls) {
		return User.class.isAssignableFrom(cls);
	}

	
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		// Unique email
		User dbUser = userService.findByEmail(user.getEmail());
		if (dbUser != null && dbUser.getId() != user.getId()) {
			errors.rejectValue("email", "Unique.user.email");
		}
	}

}
