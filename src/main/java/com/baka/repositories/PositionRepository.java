package com.baka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baka.models.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {

	
}
