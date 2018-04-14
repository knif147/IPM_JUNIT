package com.ou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ou.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
	
	List<Position> findAllByOrderByIdDesc();
	
	List<Position> findByStatusAndMajor_id(boolean status, long id);

	Position findOne(long id);
	
	Position findByNameContainingIgnoreCase(String name);
}
