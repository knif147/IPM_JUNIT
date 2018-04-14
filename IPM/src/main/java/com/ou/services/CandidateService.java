package com.ou.services;

import org.springframework.data.domain.Page;

import com.ou.entity.Candidate;

public interface CandidateService {

	Candidate findByID(int id);

	void create(Candidate candidate);
	
	void update(Candidate candidate);

	Candidate findByEmail(String email);
	
	Page<Candidate> findAllCandidatePage(int pageNumber);
}
