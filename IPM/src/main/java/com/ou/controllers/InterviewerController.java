package com.ou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ou.entity.Candidate;
import com.ou.services.InterviewerService;

@Controller
public class InterviewerController {
	@Autowired
	InterviewerService interviewerService;

	@GetMapping(value = "/interviewer/candidate")
	public String showListCandidate(Model model) {
		model.addAttribute("candidates", interviewerService.findAll());
		return "interviewerCandidateList";
	}

	@GetMapping(value = "/interviewer/candidate/{id}/information")
	public String showCandidate(@PathVariable long id, Model model) {
		Candidate candidate = interviewerService.findByID(id);
		System.out.println(candidate.getEmail());
		model.addAttribute("candidate", candidate);
		return "interviewerCandidateShow";
	}
}
