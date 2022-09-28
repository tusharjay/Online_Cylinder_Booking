package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.pojos.Cylinder;

@Repository
public interface ICylinderDao extends JpaRepository<Cylinder,Integer>{

//	@Query("select c from Cylinder c where c.cyliderType= :type")
	public Cylinder findByCylinderType(String type);
}
