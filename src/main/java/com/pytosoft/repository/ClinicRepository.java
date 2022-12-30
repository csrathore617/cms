package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

	public List<Clinic> findByDoctor(Doctor doctor);
	
	public List<Clinic> findByPatient(Patient patient);
	
	public List<Clinic> findByDoctorAndPatient(Doctor doctor,Patient patient);
}
