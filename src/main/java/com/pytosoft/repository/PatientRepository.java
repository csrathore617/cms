package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;

@EnableJpaRepositories
public interface PatientRepository extends JpaRepository<Patient, Long > {


	// public List<Patient> findByDoctor(Doctor doctor);
}
