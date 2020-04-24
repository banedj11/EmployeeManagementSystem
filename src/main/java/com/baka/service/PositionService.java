package com.baka.service;

import java.util.List;
import java.util.Optional;

import com.baka.models.Position;

public interface PositionService {

	List<Position> getAll();
	Optional<Position> getOne(Integer id);
	void savePosition(Position position);
	void deletePosition(Integer id);
}
