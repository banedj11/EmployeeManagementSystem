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

import com.baka.models.Contract;
import com.baka.service.ContractService;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@GetMapping("/contractList")
	public String getAllContracts(Model model) {
		
		List<Contract> contracts = contractService.getAll();
		model.addAttribute("contracts", contracts);
		return "contract";
	}
			
	@PostMapping("/createContract")
	public String createContract(@ModelAttribute Contract contract) {
	
		contractService.saveContract(contract);
		return "redirect:/contractList";
	}
	
	@GetMapping("/selectedContract")
	@ResponseBody
	public Optional<Contract> editForm(Integer id) {
		
		return contractService.getOne(id);
	}
	
	@RequestMapping(value = "/updateContract", method = {RequestMethod.PUT, RequestMethod.GET})
	public String editContract(@ModelAttribute Contract contract) {
		
		contractService.saveContract(contract);
		return "redirect:/contractList";
	}
	
	@RequestMapping(value = "/deleteContract", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteContract(Integer id) {
		
		contractService.deleteContract(id);
		return "redirect:/contractList";
	}
	
	
	
	
	
}
