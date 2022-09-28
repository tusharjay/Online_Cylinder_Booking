package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IBookingDao;
import com.app.dao.ICustomerDao;
import com.app.dto.BookingDto;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.util.MyUtil;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDao bookingDao;

	@Autowired
	private ICustomerDao cusDao;

	@Override
	public boolean bookCylinder(int customerId, BookingDto bDto) {

		boolean flag = false;

		System.out.println("customer id in book cylindr " + customerId);

		Optional<Customer> customer = cusDao.findById(customerId);
		if (customer.isPresent()) {
			if (cusDao.cheackConnectionStatus(customerId) != null) {
				Booking booking = new Booking();
				booking.setBookingDate(LocalDate.now());
				booking.setStatus(MyUtil.STATUS_BOOKED);

				Customer cus = customer.get();
				booking.setCustomer(cus);
				booking.setDeliveryDate(bDto.getDeliveryDate());
				booking.setAmmount(bDto.getAmmount());
				booking.setPaymentType(bDto.getPaymentType());
				bookingDao.save(booking);
				System.out.println("cylinder booked-------------------------------------");
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public List<Booking> showBookingDetails(int cusId) {

		List<Booking> bookings = bookingDao.getBookingByCustomerIdFetch(cusId);
		return bookings;
	}

	@Override
	public List<Booking> getAllBookingDetails() {
		
		return bookingDao.findAll();
	}
	

	@Override
	public boolean deleteBooking(int id) {
		
		boolean flag=false;
		try
		{
		
		Booking book=bookingDao.findById(id).get();
		
		bookingDao.delete(book);
		
		flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	

}
