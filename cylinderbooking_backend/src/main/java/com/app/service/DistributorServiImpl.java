package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDistributorDao;
import com.app.dao.LoginDao;
import com.app.dto.DistributorDto;
import com.app.pojos.Distributor;
import com.app.pojos.Login;

@Service
public class DistributorServiImpl implements IDistributorService {

	@Autowired
	private IDistributorDao disDao;

	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean addDistributor(DistributorDto distributor) {

		boolean flag = false;

		Distributor dis = new Distributor();
		try {

			dis.setFullName(distributor.getFullName());
			dis.setUserName(distributor.getUserName());
			dis.setPassword(distributor.getPassword());
			dis.setEmail(distributor.getEmail());
			dis.setMobileNumber(distributor.getMobileNumber());
			dis.setAddress(distributor.getAddress());
			dis.setCity(distributor.getCity());
			dis.setAadharCard(distributor.getAadharCard());
			dis.setLicenseNumber(distributor.getLicenseNumber());

			Login l = new Login();

			l.setPassword(distributor.getPassword());
			l.setUserName(distributor.getUserName());
			l.setRole("Distributor");

			loginDao.save(l);

			dis.setLogin_tbl(l);

			disDao.save(dis);

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
