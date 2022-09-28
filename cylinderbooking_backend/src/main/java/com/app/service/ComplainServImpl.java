package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IComplainDao;
import com.app.dao.ICustomerDao;
import com.app.dto.ComplainDto;
import com.app.pojos.Complain;
import com.app.pojos.Customer;

@Service
public class ComplainServImpl implements IComplainService {
	
	@Autowired
	private ICustomerDao cusDao;
	
	@Autowired
	private IComplainDao comDao;

	@Override
	public boolean addComplaint(int id, ComplainDto complain) {

		boolean flag = false;
		
		Optional<Customer> cusOptional=cusDao.findById(id);
		
		if(cusOptional.isPresent())
		{
			Complain com=new Complain();
			
			com.setComplaintDate(LocalDate.now());
			com.setComplainTopic(complain.getComplainTopic());
			com.setDescription(complain.getDescription());
			
			Customer customer=cusOptional.get();
			
			com.setCustomer(customer);
			
			comDao.save(com);
			
			flag=true;			
		}

		return flag;
	}

	@Override
	public List<Complain> getAllComplaint() {

		return  comDao.findAll();
	}

}
