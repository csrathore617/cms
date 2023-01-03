package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pytosoft.constants.DetailMode;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;
import com.pytosoft.repository.DoctorRepository;
import com.pytosoft.repository.PatientRepository;


@Service
public class PatientService {

	@Autowired
    PatientRepository patientRepository;
	
	@Autowired
    DoctorRepository doctorRepository;

	public Patient getPatientById(Long id, DetailMode detailMode, String accessCode) {
		return patientRepository.findById(id).get();
	}


	public void delete(Long id) {
		
		patientRepository.deleteById(id);
	}



	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}


	public List<Patient> findAllPatient() {
		return patientRepository.findAll();
		
	}

//
//	public List<Patient> findByDoctor(Long id) {
//    Doctor doctor=doctorRepository.findById(id).get();
//    return patientRepository.findByDoctor(doctor);
//	}
//
//	
}