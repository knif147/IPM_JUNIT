package com.ou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ou.entity.GroupRecruitment;

public interface GroupRecruitmentRespository extends JpaRepository<GroupRecruitment, Long> {
	List<GroupRecruitment> findAllByOrderByIdDesc();

	GroupRecruitment findOne(long id);

	GroupRecruitment findByNameContainingIgnoreCase(String name);
}
