package com.ons.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ons.demo.entities.Employe;
import com.ons.demo.services.EmployeService;

@SpringBootApplication
public class EmployeApplication implements CommandLineRunner{
	@Autowired
	EmployeService employeService;


	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//employeService.saveEmploye(new Employe("Chouk","Ons", 2600.0, new Date()));
		
		
	}

}
