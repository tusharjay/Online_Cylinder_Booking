package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.dao.IDistributorDao;
import com.app.dao.LoginDao;
import com.app.dto.LoginDto;
import com.app.pojos.Customer;
import com.app.pojos.Distributor;
import com.app.pojos.Login;
import com.app.util.LoginUtils;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ICustomerDao customerDao;

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private IDistributorDao disDao;

	@Override
	public Object checkLoginCusAndDis(LoginDto login) {

		Login l = loginDao.checkLogin(login.getUserName(), login.getPassword());        	
	    System.out.println(l);
		try
		{
			System.out.println("in check login ="+l.getRole()+" : "+l.getLogin_id() );

			if (l.getRole().equals("Customer")) 
			{
			    System.out.println("in customer-------------------------------------------");
			    System.out.println("User name = "+l.getUserName()+" ,Password = "+l.getPassword());
				Customer customer=customerDao.checkUserNameAndPassword(l.getUserName(),l.getPassword());
			  //System.out.println(customer);
				System.out.println("login done");
			   return (Object)customer;
			} 
			 else if (l.getRole().equals("Distributor")) 
			 {
				 System.out.println("in distributor-----------------------------------------");
				 Distributor dis=disDao.checkUserNameAndPassword(l.getUserName(),l.getPassword());
				System.out.println("login distributor = " +dis);
				System.out.println("login done");
			    return (Object)dis;				
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
