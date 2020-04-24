package com.baka.service;

import java.util.List;
import java.util.Optional;

import com.baka.models.Employee;

public interface EmployeeService {

	List<Employee> getAll();
	Optional<Employee> getOne(Long id);
	void saveEmployee(Employee employee);
	void saveAdmin(Employee employee);
	void deleteEmployee(Long id);
	List<Employee> findByKeyword(String keyword);
	Employee findByEmail(String name);
	void updateEmployee(Employee employee);
}
