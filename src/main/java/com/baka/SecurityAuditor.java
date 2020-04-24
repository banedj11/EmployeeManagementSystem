package com.baka;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.baka.models.Employee;
import com.baka.service.EmployeeService;

public class SecurityAuditor implements AuditorAware<String>{

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public Optional<String> getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();		
		Employee employee = employeeService.findByEmail(email);
		String name = employee.getFirstName() + " " + employee.getLastName();
		
        return Optional.ofNullable(name).filter(s -> !s.isEmpty());
	}

}
