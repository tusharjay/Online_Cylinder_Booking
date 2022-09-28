package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DistributorDto;
import com.app.service.DistributorServiImpl;

@RestController
@CrossOrigin
public class DistributorController {
	
	@Autowired
	private DistributorServiImpl disService;
	
	public DistributorController() {
		System.out.println("in distributor controller");
	}

	@PostMapping("distributor/add")
	public boolean registerDistributor(@RequestBody DistributorDto dis)
	{
		System.out.println("in register dis ="+dis);
		return disService.addDistributor(dis);
	}
}
