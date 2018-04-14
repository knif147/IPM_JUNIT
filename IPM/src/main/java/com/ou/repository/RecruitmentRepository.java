package com.ou.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ou.entity.Recruitment;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
	
	Recruitment findOne(long id);
	
	Page<Recruitment> findByGroupRecruitment_id(long group, Pageable pageable);
	
	Recruitment findByNameContainingIgnoreCase(String name);
}
