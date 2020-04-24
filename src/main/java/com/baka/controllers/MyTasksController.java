package com.baka.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baka.models.Contract;
import com.baka.models.Employee;
import com.baka.models.Task;
import com.baka.models.TaskStatus;
import com.baka.service.EmployeeService;
import com.baka.service.TaskService;
import com.baka.service.TaskStatusService;

@Controller
public class MyTasksController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskStatusService taskStatusService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/myTasks")
	public String myTasks(Model model, Principal principal) {
		
		List<TaskStatus> taskStatuses = taskStatusService.getAll();
		model.addAttribute("statuses", taskStatuses);
		String email = principal.getName();
		Employee employee = employeeService.findByEmail(email);
		List<Task> tasks = taskService.findByEmployeeId(employee.getId());
		model.addAttribute("tasks", tasks);
		return "my-tasks";
	}
	
	@GetMapping("/selectedMyTask")
	@ResponseBody
	public Optional<Task> myTask(Integer id) {
		
		return taskService.getOne(id);
	}
	
	@RequestMapping(value = "/updateTaskStatus", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateStatus(@ModelAttribute Task task) {
		
		taskService.updateTaskStatus(task);
		return "redirect:/myTasks";
	}
}
