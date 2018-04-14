package com.ou.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ou.entity.GroupRecruitment;
import com.ou.repository.GroupRecruitmentRespository;
import com.ou.utils.Constant;

@Service
public class GroupRecruitmentServiceImpl implements GroupRecruitmentService {
	@Autowired
	GroupRecruitmentRespository groupRecruitmentRespository;
	
	
	public List<GroupRecruitment> findAll() {
		return groupRecruitmentRespository.findAll();
	}

	
	public Page<GroupRecruitment> findAllGroupRecruitmentPage(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1,
				Constant.PAGE_SIZE, Sort.Direction.DESC, "id");
		return groupRecruitmentRespository.findAll(pageRequest);
	}

	
	public GroupRecruitment findOne(long id) {
		return groupRecruitmentRespository.findOne(id);
	}

	
	public GroupRecruitment findByName(String name) {
		return groupRecruitmentRespository.findByNameContainingIgnoreCase(name);
	}

	
	public void create(GroupRecruitment groupRecruitment) {
		groupRecruitment.setCreatedAt(new Date());
		groupRecruitment.setUpdatedAt(new Date());
		groupRecruitmentRespository.save(groupRecruitment);
	}

	
	public void update(GroupRecruitment groupRecruitment) {
		groupRecruitment.setUpdatedAt(new Date());
		groupRecruitmentRespository.save(groupRecruitment);
	}

}
