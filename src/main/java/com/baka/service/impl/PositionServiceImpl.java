package com.baka.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baka.models.Position;
import com.baka.repositories.PositionRepository;
import com.baka.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService{

	@Autowired
	private PositionRepository positionRepo;
	
	//Get all positions
	@Override
	public List<Position> getAll() {
		
		return positionRepo.findAll();
	}

	//Get position by id
	@Override
	public Optional<Position> getOne(Integer id) {
		
		return positionRepo.findById(id);
	}

	//Create position
	@Override
	public void savePosition(Position position) {
		
		positionRepo.save(position);
	}

	//Delete position by id
	@Override
	public void deletePosition(Integer id) {
		
		positionRepo.deleteById(id);
	}
}
