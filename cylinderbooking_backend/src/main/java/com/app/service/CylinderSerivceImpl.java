package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICylinderDao;
import com.app.pojos.Customer;
import com.app.pojos.Cylinder;

@Service
public class CylinderSerivceImpl implements ICylinderService{
	
	@Autowired
	private ICylinderDao cylinderDao;
	
	public Cylinder getCylinderByType(String type)
	{
		return cylinderDao.findByCylinderType(type);
	}

	@Override
	public boolean addCylinder(Cylinder cylinder) {
		
		boolean flag=false;
		try
		{
		Cylinder c=new Cylinder();
		
		c.setCylinderType(cylinder.getCylinderType());
		c.setWeight(cylinder.getWeight());
		cylinderDao.save(c);
		 flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public List<Cylinder> viewAllCylinder() {
		
		return cylinderDao.findAll();
	}
	
}
