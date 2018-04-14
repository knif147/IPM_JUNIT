package com.ou.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.entity.Skill;
import com.ou.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	SkillRepository skillRepository;
	
	
	public List<Skill> findAll() {
		List<Skill> skills = new ArrayList<Skill>();
		Iterable<Skill> iterator = skillRepository.findAll();
		for (Skill skill : iterator) {
			skills.add(skill);
		}
		return skills;
	}

	
	public Skill findOne(int id) {
		// TODO Auto-generated method stub
		return skillRepository.findOne(id);
	}
}
