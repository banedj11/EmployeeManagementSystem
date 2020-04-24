package com.baka.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baka.models.Contract;
import com.baka.models.Employee;
import com.baka.models.Position;
import com.baka.service.ContractService;
import com.baka.service.EmployeeService;
import com.baka.service.PositionService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private PositionService positionService;
	
	@GetMapping("/employeeList")
	public String getAllEmployees(Model model, String keyword) {
		
		List<String> genders = Arrays.asList("Male", "Female");
		model.addAttribute("genders", genders);
		List<Contract> contracts = contractService.getAll();
		model.addAttribute("contracts", contracts);
		List<Position> positions = positionService.getAll();
		model.addAttribute("positions", positions);
		List<Employee> employees = employeeService.getAll();
		
		if(keyword != null) {
			model.addAttribute("employees", employeeService.findByKeyword(keyword));
		}
		else {
			model.addAttribute("employees", employees);
		}
		return "employee";
	}
	
	@PostMapping("/createEmployee")
	public String createEmployee(@ModelAttribute Employee employee, Model model, @RequestParam("photo") MultipartFile photo) throws IllegalStateException, IOException {

		employeeService.saveEmployee(employee);
		String baseDirectory = "C:\\Users\\WINDOWS 10\\Documents\\SpringBoot\\MyEmployeeManagementSystem\\src\\main\\resources\\static\\img" ;
		photo.transferTo(new File(baseDirectory + employee.getId() + ".jpg"));
		return "redirect:/employeeList";
	}
	
	@GetMapping("/selectedEmployee")
	@ResponseBody
	public Optional<Employee> editForm(Long id, Model model) {
		
		return employeeService.getOne(id);
	}
	
	@RequestMapping(value = "/updateEmployee", method = {RequestMethod.PUT, RequestMethod.GET})
	public String editEmployee(@ModelAttribute Employee employee) {
		
		employeeService.updateEmployee(employee);
		return "redirect:/employeeList";
	}
	
	@RequestMapping(value = "/deleteEmployee", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteEmployee(Long id) {
		
		employeeService.deleteEmployee(id);
		return "redirect:/employeeList";
	}
}
