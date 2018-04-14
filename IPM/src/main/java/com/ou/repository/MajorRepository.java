package com.ou.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ou.entity.Major;

public interface MajorRepository extends JpaRepository<Major, Long> {
	
	List<Major> findAllByOrderByIdDesc();
	
	List<Major> findByStatus(boolean status);
	
	@Query("select m from Major m where m.name like ?1%")
	Page<Major> findByName(String name, Pageable pageable);

	Major findOne(long id);
	
	Major findByNameContainingIgnoreCase(String name);

}
