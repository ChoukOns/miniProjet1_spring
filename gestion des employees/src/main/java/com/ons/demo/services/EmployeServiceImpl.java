package com.ons.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ons.demo.entities.Employe;
import com.ons.demo.repos.EmployeRepository;

@Service
public class EmployeServiceImpl implements EmployeService{
	
	@Autowired 
	EmployeRepository employeRepository;
	
	@Override
	public Employe saveEmploye(Employe e) 
	{ return employeRepository.save(e);
	}
	
	@Override
	public Employe updateEmploye(Employe e) 
	{ return employeRepository.save(e);
	}
	
	@Override
	public void deleteEmploye(Employe e) 
	{ employeRepository.delete(e);
	}
	
	@Override
	public void deleteEmployeById(Long id) {
	employeRepository.deleteById(id);
	}
	
	@Override
	public Employe getEmploye(Long id) { return employeRepository.findById(id).get();
	}
	
	@Override
	public List<Employe> getAllEmployes() { return employeRepository.findAll();
	}
	
	@Override
	public Page<Employe> getAllEmployeesParPage(int page, int size) {
		return employeRepository.findAll(PageRequest.of(page, size));
	}

}
