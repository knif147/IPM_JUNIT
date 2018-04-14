package com.ou.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ou.entity.Major;

public interface MajorService {

	List<Major> findAll();

	Page<Major> findAllPage(int pageNumber);

	Page<Major> findByNamePage(int pageNumber, String name);
	
	List<Major> findByStatus();

	Major findOne(long id);

	Major findByName(String name);

	void create(Major major);

	void update(Major major);
}
