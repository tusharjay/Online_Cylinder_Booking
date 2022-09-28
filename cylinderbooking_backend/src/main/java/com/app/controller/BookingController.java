package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingDto;
import com.app.pojos.Booking;
import com.app.service.BookingServiceImpl;
import com.app.service.IBookingService;

@RestController
@CrossOrigin
public class BookingController {
	
	@Autowired
	private BookingServiceImpl bookingService;

	public BookingController() {
		System.out.println("in booking controller");
	}
	
	@PostMapping("book/{cusid}")
	public boolean bookCylinder(@PathVariable("cusid") int id,@RequestBody BookingDto bDTO )
	{
		System.out.println("in book sylinder "+ id+" booking info "+bDTO);
		return bookingService.bookCylinder(id, bDTO);
	}
	
	@GetMapping("allbooking")
	public List<Booking> getAllBooking()
	{
		return bookingService.getAllBookingDetails();
	}
	
	@GetMapping("showbook/{cid}")
	public List<Booking> showAllBooking(@PathVariable("cid") int cid)
	{
		System.out.println("in show booking cid ="+cid);
		return bookingService.showBookingDetails(cid);
	}
	
	@GetMapping("cancelbook/{bid}")
	public boolean canclBooking(@PathVariable("bid") int id)
	{
		return bookingService.deleteBooking(id);
	}
}
