package com.baka.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.baka.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByEmployeeId(Long employeeId);

}
