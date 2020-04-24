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

import com.baka.models.Position;
import com.baka.service.PositionService;

@Controller
public class PositionController {

	@Autowired
	private PositionService positionService;
	
	@GetMapping("/positionList")
	public String getAllPositions(Model model) {
		
		List<Position> positions = positionService.getAll();
		model.addAttribute("positions", positions);
		return "position";
	}
			
	@PostMapping("/createPosition")
	public String createPosition(@ModelAttribute Position position) {
	
		positionService.savePosition(position);
		return "redirect:/positionList";
	}
	
	@GetMapping("/selectedPosition")
	@ResponseBody
	public Optional<Position> editForm(Integer id) {
		
		return positionService.getOne(id);
	}
	
	@RequestMapping(value = "/updatePosition", method = {RequestMethod.PUT, RequestMethod.GET})
	public String editPosition(@ModelAttribute Position position) {
		
		positionService.savePosition(position);
		return "redirect:/positionList";
	}
	
	@RequestMapping(value = "/deletePosition", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deletePosition(Integer id) {
		
		positionService.deletePosition(id);
		return "redirect:/positionList";
	}
}
