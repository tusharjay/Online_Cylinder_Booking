package com.app.service;

import java.util.List;

import com.app.dto.BookingDto;
import com.app.pojos.Booking;

public interface IBookingService {
	
	public boolean bookCylinder (int customerId,BookingDto bDto);
	
	public List<Booking> showBookingDetails(int cusId);
	
	public List<Booking> getAllBookingDetails();
	
	public boolean deleteBooking(int id);

}
