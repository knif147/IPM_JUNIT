package com.ou.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ou.entity.Candidate;
import com.ou.services.CandidateService;

@Component
public class CandidateValidator implements Validator {
	@Autowired
	CandidateService candidateService;

	
	public boolean supports(Class<?> cls) {
		return Candidate.class.isAssignableFrom(cls);
	}

	
	public void validate(Object o, Errors errors) {
		Candidate candidate = (Candidate) o;
		// Unique email
		Candidate dbCandidate = candidateService.findByEmail(candidate.getEmail());
		if (dbCandidate != null && dbCandidate.getId() != dbCandidate.getId()) {
			errors.rejectValue("email", "Unique.candidate.email");
		}
	}
}
