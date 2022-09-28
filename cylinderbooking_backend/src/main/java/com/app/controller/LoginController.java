package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.LoginDto;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.service.ILoginService;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private ILoginService  loginService;
	
	public LoginController() {
		System.out.println("in login controller");
	}
	
	@PostMapping("/login")
	public Object loginUser(@RequestBody LoginDto loginCus)
	{
		System.out.println("in login ------"+ loginCus);
		return loginService.checkLoginCusAndDis(loginCus);
	}

}
