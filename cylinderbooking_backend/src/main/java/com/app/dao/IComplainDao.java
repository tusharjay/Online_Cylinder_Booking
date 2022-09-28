package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Complain;

@Repository
public interface IComplainDao extends JpaRepository<Complain,Integer>{

}
