package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.pojos.Booking;

@Repository
public interface IBookingDao extends JpaRepository<Booking,Integer>{
	
	@Query("from Booking b inner join fetch b.customer c where c.customerId=:cid")
	public List<Booking> getBookingByCustomerIdFetch(@Param("cid") int id);
	
	@Query("select b from Booking b where b.customer.customerId=:cid")
	public List<Booking> getBookingByCustomerId(@Param("cid") int id);

}
