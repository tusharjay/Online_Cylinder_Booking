package com.app.service;

import java.util.List;

import com.app.dto.ComplainDto;
import com.app.pojos.Complain;

public interface IComplainService {
	
	public boolean addComplaint(int id,ComplainDto complain);

	public List<Complain> getAllComplaint();
}
