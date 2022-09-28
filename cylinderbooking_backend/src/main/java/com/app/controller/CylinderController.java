package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cylinder;
import com.app.service.CylinderSerivceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CylinderController {
	
	@Autowired
	private CylinderSerivceImpl cylinderService;
	
	public CylinderController() {
		System.out.println("in cylinder controller");
	}
	
	@GetMapping("cylinder/show")
	public List<Cylinder> getAllCylinder()
	{
		return cylinderService.viewAllCylinder();
	}
	
	@PostMapping("cylinder/add")
	public boolean addCylinder(@RequestBody Cylinder cyl)
	{
		return cylinderService.addCylinder(cyl);
	}
}
