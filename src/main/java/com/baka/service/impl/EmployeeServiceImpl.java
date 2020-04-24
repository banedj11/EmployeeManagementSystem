package com.baka.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baka.models.Employee;
import com.baka.models.Role;
import com.baka.repositories.EmployeeRepository;
import com.baka.repositories.RoleRepository;
import com.baka.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//Create employee
	@Override
	public void saveEmployee(Employee employee) {
		
		
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Role role = roleRepo.findByName("EMPLOYEE");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		employee.setRoles(roles);
		employeeRepo.save(employee);
	}
	
	//Create Admin
	@Override
	public void saveAdmin(Employee employee) {
		
		
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Role role = roleRepo.findByName("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		employee.setRoles(roles);
		employeeRepo.save(employee);
	}
	
	//Get all employees
	@Override
	public List<Employee> getAll() {
		
		return employeeRepo.findAll();
	}

	//Get employee by id
	@Override
	public Optional<Employee> getOne(Long id) {
		
		return employeeRepo.findById(id);
	}

    //Delete employee by id
	@Override
	public void deleteEmployee(Long id) {
		
		employeeRepo.deleteById(id);
	}

	//Find employees by keyword
	@Override
	public List<Employee> findByKeyword(String keyword) {
		
		return employeeRepo.findByKeyword(keyword);
	}

	//Find employee by email
	@Override
	public Employee findByEmail(String email) {
		
		return employeeRepo.findEmployeeByEmail(email);
	}

	@Transactional
	@Override
	public void updateEmployee(Employee employee) {
		
        Employee currentEmployee = employeeRepo.findById(employee.getId()).orElse(new Employee());
		
		List<Role> roles = currentEmployee.getRoles();
		employee.setPassword(currentEmployee.getPassword());
		employee.setRoles(roles);
		employeeRepo.save(employee);
	}


}
