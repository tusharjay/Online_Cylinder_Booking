package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ComplainDto;
import com.app.pojos.Complain;
import com.app.service.ComplainServImpl;

@RestController
@CrossOrigin
public class ComplainController {
	
	@Autowired
	private ComplainServImpl comService;
	
	public ComplainController() {
		System.out.println("in complain controller");
	}
	
	@PostMapping("savecomplain/{id}")
	public boolean SaveComplaint(@PathVariable("id") int id,@RequestBody ComplainDto com)
	{
		return comService.addComplaint(id, com);
	}
	
	@GetMapping("allcomplain")
	public List<Complain> showAllComplain()
	{
		return comService.getAllComplaint();
	}
	
	

}
