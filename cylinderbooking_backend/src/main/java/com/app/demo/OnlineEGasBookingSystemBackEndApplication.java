package com.app.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.dao.IConnectionTypeDao;
import com.app.pojos.Cylinder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.app.dao")
@EntityScan(basePackages = "com.app.pojos")
@ComponentScan(basePackages = "com.app.service")
@ComponentScan(basePackages = "com.app.controller")
public class OnlineEGasBookingSystemBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEGasBookingSystemBackEndApplication.class, args);
	}

//	@Bean
//	CommandLineRunner initDatabase(IConnectionTypeDao conDao) {
//		return args -> {
//			System.out.println("in sample data ");
//			conDao.save(new Cylinder("domestic", 80.00f));
//			conDao.save(new Cylinder("industrials", 150.00f));
//
//		};
//	}

}
