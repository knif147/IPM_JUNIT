package com.ou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.repository.UserRepository;

@Service
public class HRServiceImpl implements HRService {
	@Autowired
	UserRepository userRepository;
}
