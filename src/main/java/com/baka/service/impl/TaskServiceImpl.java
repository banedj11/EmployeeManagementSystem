package com.baka.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baka.models.Task;
import com.baka.models.TaskStatus;
import com.baka.repositories.TaskRepository;
import com.baka.repositories.TaskStatusRepository;
import com.baka.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepo;
	
	
	//Create Task
	@Override
	public void saveTask(Task task) {
		
		
		task.setTaskstatus_id(1);
		taskRepo.save(task);
	}
	//Get one task
	@Override
	public Optional<Task> getOne(Integer id) {
		
		return taskRepo.findById(id);
	}

	//Get all tasks
	@Override
	public List<Task> getAll() {
		
		return taskRepo.findAll();
	}

	//Delete task
	@Override
	public void deleteTask(Integer id) {
 		
        taskRepo.deleteById(id);		
	}
	
	//Find task by employee id
	@Override
	public List<Task> findByEmployeeId(Long employeeId) {
		
		return taskRepo.findByEmployeeId(employeeId);
	}
	@Override
	public void updateTaskStatus(Task task) {
		
		Task curentTask = taskRepo.findById(task.getId()).orElse(new Task());
		curentTask.setTaskstatus_id(task.getTaskstatus_id());
		taskRepo.save(curentTask);
	}

}
