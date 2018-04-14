package com.ou.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ou.entity.User;
import com.ou.repository.UserRepository;
import com.ou.utils.Constant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	public void create(User user, int role) {
		user.setRole(role);
		user.setStatus(true);
		user.setPassword(passwordEncoder.encode("123456789"));
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		
		userRepository.save(user);
	}

	
	public void update(User user) {
		user.setUpdatedAt(new Date());
		userRepository.save(user);
	}
	
	
	public User findById(long id) {
		return userRepository.findOne(id);
	}

	
	public Page<User> findAllUserPage(int pageNumber, int role) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1,
				Constant.PAGE_SIZE, Sort.Direction.DESC, "id");
		return userRepository.findByRole(role, pageRequest);
	}


	@Override
	public User login(String username, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

}
