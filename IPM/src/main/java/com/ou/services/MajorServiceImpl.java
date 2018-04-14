package com.ou.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ou.entity.Major;
import com.ou.repository.MajorRepository;
import com.ou.utils.Constant;

@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	MajorRepository majorRepository;
	
	
	public List<Major> findAll() {
		return majorRepository.findAll();
	}

	
	public Major findOne(long id) {
		return majorRepository.findOne(id);
	}

	
	public Page<Major> findAllPage(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1,
				Constant.PAGE_SIZE, Sort.Direction.DESC, "id");
		return majorRepository.findAll(pageRequest);
	}

	
	public Page<Major> findByNamePage(int pageNumber, String name) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1,
				Constant.PAGE_SIZE, Sort.Direction.DESC, "id");
		return majorRepository.findByName(name, pageRequest);
	}
	
	
	public void create(Major major) {
		major.setCreatedAt(new Date());
		major.setUpdatedAt(new Date());
		major.setStatus(true);
		
		majorRepository.save(major);
	}

	
	public Major findByName(String name) {
		return majorRepository.findByNameContainingIgnoreCase(name);
	}

	
	public void update(Major major) {
		major.setUpdatedAt(new Date());
		majorRepository.save(major);
	}

	
	public List<Major> findByStatus() {
		return majorRepository.findByStatus(true);
	}
}
