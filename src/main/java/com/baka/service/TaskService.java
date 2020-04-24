package com.baka.service;

import java.util.List;
import java.util.Optional;

import com.baka.models.Task;

public interface TaskService {

	Optional<Task> getOne(Integer id);
	List<Task> getAll();
	void saveTask(Task task);
	void deleteTask(Integer id);
	List<Task> findByEmployeeId(Long employeeId);
	void updateTaskStatus(Task task);

}
