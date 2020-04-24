package com.baka.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.baka.models.Employee;
import com.baka.service.EmployeeService;


@Controller
public class LoginController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/")
    public String home(Model model, Principal principal) {
    	
		String email = principal.getName();
		Employee employee = employeeService.findByEmail(email);
		String name = employee.getFirstName() + " " + employee.getLastName();
		model.addAttribute("employee", name);
		
    	return "index";
    }
}
