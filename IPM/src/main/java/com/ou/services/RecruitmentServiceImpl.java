package com.ou.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ou.authentication.CustomUserDetails;
import com.ou.entity.Recruitment;
import com.ou.entity.User;
import com.ou.repository.RecruitmentRepository;
import com.ou.utils.Constant;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
	@Autowired
	RecruitmentRepository recruitmentRepository;

	
	public List<Recruitment> findAll() {
		return recruitmentRepository.findAll();
	}

	
	public Recruitment findOne(int id) {
		return recruitmentRepository.findOne(id);
	}

	
	public Page<Recruitment> findByGroupRecruitment(int pageNumber, long group) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1, Constant.PAGE_SIZE, Sort.Direction.DESC, "id");
		return recruitmentRepository.findByGroupRecruitment_id(group, pageRequest);
	}

	
	public void create(Recruitment recruitment) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User currentUser = ((CustomUserDetails) principal).getUser();
		recruitment.setUser(currentUser);
		recruitment.setStatus(true);
		recruitment.setCreatedAt(new Date());
		recruitment.setUpdatedAt(new Date());

		recruitmentRepository.save(recruitment);
	}

	
	public void update(Recruitment recruitment) {
		recruitment.setUpdatedAt(new Date());
		recruitmentRepository.save(recruitment);
	}

	
	public Recruitment findByName(String name) {
		return recruitmentRepository.findByNameContainingIgnoreCase(name);
	}
}
