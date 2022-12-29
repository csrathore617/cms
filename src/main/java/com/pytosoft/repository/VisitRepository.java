package com.pytosoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;
import com.pytosoft.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long>{
	
//	Visit findByName(String Visit);
	
	Optional<Visit> findById(Long visitId);
	
//	Visit findByPatient(Long id);
	
//	Visit findByDoctor(Doctor doctor);
	
//	Visit findByPatient(Patient patient);
	

}
