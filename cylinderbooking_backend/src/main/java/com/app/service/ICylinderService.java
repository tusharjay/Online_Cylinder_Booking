package com.app.service;

import java.util.List;

import com.app.pojos.Cylinder;

public interface ICylinderService {
	
	public boolean addCylinder(Cylinder cylinder);
	
	public List<Cylinder> viewAllCylinder();

}
