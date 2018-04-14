package com.ou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.repository.InterviewRepository;

@Service
public class InterviewServiceImpl implements InterviewService {
	@Autowired
	InterviewRepository interviewRepository;
}
