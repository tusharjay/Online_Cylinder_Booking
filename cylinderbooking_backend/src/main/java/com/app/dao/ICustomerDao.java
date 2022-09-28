package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.pojos.Customer;
import com.app.pojos.Cylinder;


@Repository
public interface ICustomerDao extends JpaRepository<Customer,Integer>{
	
	@Query("select c from Customer c where c.customerId=:id and c.connectionStatus='active'")
	public Customer cheackConnectionStatus(@Param("id") int id);
	
	@Query("select c from Customer c where c.userName=:uname and c.password=:pass")
	public Customer checkUserNameAndPassword(@Param("uname") String uname,@Param("pass") String pass);
		
	@Query("select c from Customer c where c.customerId=:id")
	public Customer getCustomerById(@Param("id") int id);
	
	@Query("select c from Customer c where c.login_tbl.login_id=:id")
	public Customer getCustomerByLoginId(@Param("id") int id);
	
	@Query("select c from Customer c where c.userName=:un and c.mobileNumber=:mb")
	public Customer getCustomerByUserNameAndMob(@Param("un") String userName,@Param("mb") String mobileNumber);

}
