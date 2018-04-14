package com.ou.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ou.entity.Recruitment;

public interface RecruitmentService {
	List<Recruitment> findAll();

	Recruitment findOne(int id);
	
	Page<Recruitment> findByGroupRecruitment(int pageNumber, long group);
	
	Recruitment findByName(String name);
	
	void create(Recruitment recruitment);
	
	void update(Recruitment recruitment);
}
