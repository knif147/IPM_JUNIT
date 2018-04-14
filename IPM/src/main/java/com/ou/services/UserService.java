package com.ou.services;

import org.springframework.data.domain.Page;
import org.springframework.security.core.AuthenticationException;

import com.ou.entity.User;

public interface UserService {
	
	User findByEmail(String email);

	Page<User> findAllUserPage(int pageNumber, int role);
	
	User findById(long id);
	
	void create(User user,int role);
	
	void update(User user);
	
	User login(String username, String password) throws AuthenticationException;
	
}
