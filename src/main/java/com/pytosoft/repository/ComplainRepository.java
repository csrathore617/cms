package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Complain;
import com.pytosoft.model.Doctor;

public interface ComplainRepository extends JpaRepository<Complain, Integer> {
	
	public List<Complain> findByDoctor(Doctor doctor);
}
