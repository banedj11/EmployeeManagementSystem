package com.baka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baka.models.Employee;
import com.baka.models.EmployeePrincipal;
import com.baka.repositories.EmployeeRepository;

@Service
public class EmployeeDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee = employeeRepo.findEmployeeByEmail(username);
		if(employee == null) {
			throw new UsernameNotFoundException("Employee not found");
		}
		return new EmployeePrincipal(employee);
	}

}
