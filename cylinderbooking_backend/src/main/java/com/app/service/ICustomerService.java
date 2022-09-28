package com.app.service;

import java.util.List;

import com.app.dto.CustomerDto;
import com.app.dto.ForgotPasswordDto;
import com.app.pojos.Customer;

public interface ICustomerService {
	
	public boolean insertCustomer(CustomerDto customer);
	
	public List<Customer> getAllCustomer();
	
	public boolean updateCustomer(CustomerDto customer,int id);

	public Customer getByIdCus(int id);
	
	public boolean forgotPaaword(ForgotPasswordDto fp);
}
