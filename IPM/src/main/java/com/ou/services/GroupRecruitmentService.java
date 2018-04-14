package com.ou.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ou.entity.GroupRecruitment;

public interface GroupRecruitmentService {
	List<GroupRecruitment> findAll();

	Page<GroupRecruitment> findAllGroupRecruitmentPage(int pageNumber);

	GroupRecruitment findOne(long id);

	GroupRecruitment findByName(String name);

	void create(GroupRecruitment groupRecruitment);

	void update(GroupRecruitment groupRecruitment);
}
