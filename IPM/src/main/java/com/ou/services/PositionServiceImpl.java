package com.ou.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ou.entity.Position;
import com.ou.repository.PositionRepository;
import com.ou.utils.Constant;

@Service
public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionRepository positionRepository;
	
	
	public List<Position> findAll() {
		return positionRepository.findAllByOrderByIdDesc();
	}

	
	public Position findOne(long id) {
		return positionRepository.findOne(id);
	}
	
	
	public Page<Position> findAllPositionPage(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1,
				Constant.PAGE_SIZE, Sort.Direction.DESC, "id");
		return positionRepository.findAll(pageRequest);
	}

	
	public Position findByName(String name) {
		return positionRepository.findByNameContainingIgnoreCase(name);
	}

	
	public void create(Position position) {
		position.setCreatedAt(new Date());
		position.setUpdatedAt(new Date());
		position.setStatus(true);
		positionRepository.save(position);
	}

	
	public void update(Position position) {
		position.setCreatedAt(new Date());
		positionRepository.save(position);
	}

	
	public List<Position> findByStatus(long idMajor) {
		return positionRepository.findByStatusAndMajor_id(true, idMajor);
	}

}
