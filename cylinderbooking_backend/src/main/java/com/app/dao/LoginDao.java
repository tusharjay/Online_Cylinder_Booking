package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer>{
	
	@Query("select l from Login l where l.userName=:un and l.password=:pass")
	public Login checkLogin(@Param("un") String userName,@Param("pass") String password);
	
	@Query ("select l from Login l where l.login_id=:id")
	public Login getLoginUser(@Param("id") int id);
	
	@Query("select l from Login l where l.userName=:un")
	public Login getLoginByUserName(@Param("un") String userName);

}
