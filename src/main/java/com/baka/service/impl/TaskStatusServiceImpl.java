package com.baka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baka.models.TaskStatus;
import com.baka.repositories.TaskStatusRepository;
import com.baka.service.TaskStatusService;

@Service
public class TaskStatusServiceImpl implements TaskStatusService{

	@Autowired
	private TaskStatusRepository taskStatusRepo;

	@Override
	public List<TaskStatus> getAll() {
		
		return taskStatusRepo.findAll();
	}

	@Override
	public void updateTaskStatus(TaskStatus taskStatus) {
		
		taskStatusRepo.save(taskStatus);
	}
}
