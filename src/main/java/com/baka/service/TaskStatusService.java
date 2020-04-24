package com.baka.service;

import java.util.List;

import com.baka.models.TaskStatus;

public interface TaskStatusService {

	List<TaskStatus> getAll();
	void updateTaskStatus(TaskStatus taskStatus);
}
