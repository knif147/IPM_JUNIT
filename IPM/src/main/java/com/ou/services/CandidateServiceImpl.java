package com.ou.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ou.authentication.CustomUserDetails;
import com.ou.entity.Candidate;
import com.ou.entity.User;
import com.ou.repository.CandidateRepository;
import com.ou.utils.Constant;

@Service
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateRepository candidateRepository;

	
	public Candidate findByID(int id) {
		return candidateRepository.findOne(id);
	}

	
	public Candidate findByEmail(String email) {
		return candidateRepository.findByEmail(email);
	}

	
	public void create(Candidate candidate) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User currentUser = ((CustomUserDetails) principal).getUser();
		candidate.setUser(currentUser);
		candidate.setStatus(true);
		candidate.setCreatedAt(new Date());
		candidate.setUpdatedAt(new Date());

		candidateRepository.save(candidate);
	}

	
	public void update(Candidate candidate) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User currentUser = ((CustomUserDetails) principal).getUser();
		candidate.setUser(currentUser);
		candidate.setUpdatedAt(new Date());

		candidateRepository.save(candidate);
	}

	
	public Page<Candidate> findAllCandidatePage(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1,
				Constant.PAGE_SIZE, Sort.Direction.DESC, "id");
		return candidateRepository.findAll(pageRequest);
	}
}
