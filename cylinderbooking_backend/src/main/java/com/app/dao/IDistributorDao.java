package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Distributor;


@Repository
public interface IDistributorDao extends JpaRepository<Distributor,Integer>{

	@Query("select d from Distributor d where d.userName=:uname and d.password=:pass")
	public Distributor checkUserNameAndPassword(@Param("uname") String uname,@Param("pass") String pass);
}
