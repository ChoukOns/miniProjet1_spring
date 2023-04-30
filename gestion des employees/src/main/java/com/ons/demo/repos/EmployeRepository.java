package com.ons.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ons.demo.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
