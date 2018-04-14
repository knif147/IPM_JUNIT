package com.ou.services;

import java.util.List;

import com.ou.entity.Candidate;

public interface InterviewerService {
	List<Candidate> findAll();

	Candidate findByID(long id);
}
