package com.ou.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.entity.Candidate;
import com.ou.repository.CandidateRepository;

@Service
public class InterviewerServiceImpl implements InterviewerService {
	@Autowired
	CandidateRepository candidateRepository;

	
	public List<Candidate> findAll() {
		List<Candidate> candidates = new ArrayList<Candidate>();

		Iterable<Candidate> iterator = candidateRepository.findAll();
		for (Candidate candidate : iterator) {
			candidates.add(candidate);
		}

		return candidates;
	}

	
	public Candidate findByID(long id) {
		return candidateRepository.findOne(id);
	}
}
