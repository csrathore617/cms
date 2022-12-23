package com.pytosoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Doctor;
import com.pytosoft.repository.custom.CustomDoctorRepo;


public interface DoctorRepo extends JpaRepository<Doctor, Long>,CustomDoctorRepo {
	
	Optional<Doctor> findByDoctorName(String doctorName);
	
	boolean existsByDoctorName(String doctorName);
	
	Optional<Long> countByDoctorName(String doctorName);
	
	void deleteByDoctorName(String doctorName);
}
