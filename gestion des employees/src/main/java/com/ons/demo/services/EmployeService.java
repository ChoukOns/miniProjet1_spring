package com.ons.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ons.demo.entities.Employe;

public interface EmployeService {
	Employe saveEmploye(Employe e);
	Employe updateEmploye(Employe e);
	void deleteEmploye(Employe e);
	void deleteEmployeById(Long id);
	Employe getEmploye(Long id);
	List<Employe> getAllEmployes();
	Page<Employe> getAllEmployeesParPage(int page, int size);

}
