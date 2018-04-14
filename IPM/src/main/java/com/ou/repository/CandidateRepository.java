package com.ou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ou.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
	List<Candidate> findAllByOrderByIdDesc();

	Candidate findOne(long id);
	
	Candidate findByEmail(String email);
	
}
