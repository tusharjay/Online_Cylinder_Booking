package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.CustomerDto;
import com.app.dto.ForgotPasswordDto;
import com.app.pojos.Customer;
import com.app.service.CustomerServiceImpl;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl cusService;
	
	public CustomerController() {
		System.out.println("in customer cntroller");
	}
	
	@GetMapping("customer/show")
	public List<Customer> ShowAllCusttomer()
	{
		System.out.println("in show all mwthod");
		return cusService.getAllCustomer();
	}
	
	@PostMapping("customer/add")
	public boolean insertCustomer(@RequestBody CustomerDto cus)
	{
		System.out.println("in add customer controller  "+cus);
		return cusService.insertCustomer(cus);
	}
	
	@PutMapping("customer/update/{cusid}")
	public boolean updateCustomer(@RequestBody CustomerDto cus, @PathVariable("cusid") int id)
	{
		return cusService.updateCustomer(cus, id);
	}
	
	@GetMapping("customer/{id}")
	public Customer getByIDCustomet(@PathVariable("id") int id)
	{
		System.out.println(id);
		return cusService.getByIdCus(id);
	}
	
	
	@PostMapping("changepass")
	public boolean changePassword(@RequestBody ForgotPasswordDto fPass)
	{
		System.out.println("in customer controller = "+fPass);
		return cusService.forgotPaaword(fPass);
	}

}
