package com.baka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baka.models.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Integer>{

	TaskStatus findByStatus(String status);
}
