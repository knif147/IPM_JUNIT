package com.ou.repository;

import org.springframework.data.repository.CrudRepository;

import com.ou.entity.Skill;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
	Iterable<Skill> findAll();

	Skill findOne(int id);
}
