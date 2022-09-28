package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Cylinder;

@Repository
public interface IConnectionTypeDao extends JpaRepository<Cylinder,Integer> {

}
