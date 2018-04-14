package com.ou.services;

import java.util.List;

import com.ou.entity.Skill;

public interface SkillService {
	List<Skill> findAll();

	Skill findOne(int id);
}
