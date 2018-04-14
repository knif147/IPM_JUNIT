package com.ou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.repository.ResultInterviewRepository;

@Service
public class ResultInterviewServiceImpl implements ResultInterviewService {
	@Autowired
	ResultInterviewRepository resultInterviewRepository;
}
