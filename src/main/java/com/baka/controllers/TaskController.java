package com.baka.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.baka.models.Employee;
import com.baka.models.Task;
import com.baka.service.EmployeeService;
import com.baka.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/taskList")
	public String getAllTasks(Model model, Long employeeId) {
		
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		List<Task> tasks = taskService.getAll();
		
		if(employeeId != null) {
			model.addAttribute("tasks", taskService.findByEmployeeId(employeeId));
		}
		else {
			model.addAttribute("tasks", tasks);
		}
		return "task";
	}
			
	@PostMapping("/createTask")
	public String createTask(@ModelAttribute Task task) {
	
		taskService.saveTask(task);
		return "redirect:/taskList";
	}
	
	@GetMapping("/selectedTask")
	@ResponseBody
	public Optional<Task> editForm(Integer id) {
		
		return taskService.getOne(id);
	}
	
	@RequestMapping(value = "/updateTask", method = {RequestMethod.PUT, RequestMethod.GET})
	public String editTask(@ModelAttribute Task task) {
		
		taskService.saveTask(task);
		return "redirect:/taskList";
	}
	
	@RequestMapping(value = "/deleteTask", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteTask(Integer id) {
		
		taskService.deleteTask(id);
		return "redirect:/taskList";
	}
}
