package com.ou.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ou.entity.Position;

public interface PositionService {
	List<Position> findAll();
	
	List<Position> findByStatus(long idMajor);
	
	Page<Position> findAllPositionPage(int pageNumber);

	Position findOne(long id);
	
	Position findByName(String name);
	
	void create(Position position);
	
	void update(Position position);
	
}
