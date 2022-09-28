package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.dao.ICylinderDao;
import com.app.dao.LoginDao;
import com.app.dto.CustomerDto;
import com.app.dto.ForgotPasswordDto;
import com.app.pojos.Customer;
import com.app.pojos.Cylinder;
import com.app.pojos.Login;
import com.app.util.MyUtil;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao cusDao;

	@Autowired
	private ICylinderDao cylDao;

	@Autowired
	private LoginDao loginDao;

	@Override
	public List<Customer> getAllCustomer() {
		System.out.println("in get all customer service");
		return cusDao.findAll();
	}

	@Override
	public boolean insertCustomer(CustomerDto customer) {
		boolean flag = false;

		try {
			System.out.println("custometer cylinder type " + customer.getCylinderType());
			Cylinder cylinder = cylDao.findByCylinderType(customer.getCylinderType());
			System.out.println(cylinder);
			if (cylinder != null) {

				Customer cus = new Customer();
				cus.setFullName(customer.getFullName());
				cus.setUserName(customer.getUserName());
				cus.setPassword(customer.getPassword());
				cus.setEmail(customer.getEmail());
				cus.setMobileNumber(customer.getMobileNumber());
				cus.setAadharCard(customer.getAadharCard());
				cus.setAddress(customer.getAddress());
				cus.setCity(customer.getCity());
				cus.setConnectionStatus(MyUtil.CONNECTION_ACTIVE);
				cus.setCylinder(cylinder);
				//cus.setLogin_tbl(customer.getLogin());
				Login l = new Login();
				l.setPassword(customer.getPassword());
				l.setRole("Customer");
				l.setUserName(customer.getUserName());

				loginDao.save(l);

				cus.setLogin_tbl(l);

				cusDao.save(cus);

				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean updateCustomer(CustomerDto customer, int id) {

		     boolean flag = false;
			// Optional<Customer> cusOptional = cusDao.findById(id);
                 
		     Customer cus=cusDao.getById(id);
		     System.out.println("----cus by get id = " +cus);
			 if (cus != null) {
				//Customer cus = cusOptional.get();
				cus.setFullName(customer.getFullName());
				cus.setUserName(customer.getUserName());
				cus.setPassword(customer.getPassword());
				cus.setMobileNumber(customer.getMobileNumber());
				cus.setEmail(customer.getEmail());
				cus.setAadharCard(customer.getAadharCard());
				cus.setAddress(customer.getAddress());
				cus.setCity(customer.getCity());
				
				Cylinder cl = cylDao.findByCylinderType(customer.getCylinderType());

				System.out.println("cylinder------------" + cl);
				if (cl != null) {
					cus.setCylinder(cl);
				}
				
				cusDao.save(cus);
				System.out.println(cus);
				flag = true;
			}
		return flag;
	}

	@Override
	public Customer getByIdCus(int id) {
		Optional<Customer> cusOptional = cusDao.findById(id);		
		//System.out.println(cusOptional);
		return cusOptional.get();
	}

	@Override
	public boolean forgotPaaword(ForgotPasswordDto fp) {
		boolean flag=false;		
		try
		{
			Customer customer=cusDao.getCustomerByUserNameAndMob(fp.getUserName(),fp.getMobileNumber());
			//System.out.println(customer);
			customer.setPassword(fp.getNewPassword());
			Login l=loginDao.getLoginByUserName(fp.getUserName());
			
			  l.setPassword(fp.getNewPassword());
			  loginDao.save(l);
			cusDao.save(customer);
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
