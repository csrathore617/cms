package com.pytosoft.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.constants.DetailMode;
import com.pytosoft.model.Patient;
import com.pytosoft.repository.PatientRepository;


@Service
public class PatientService {

	@Autowired
	PatientRepository patientrepo;

	public Patient getPatientById(Long id, DetailMode detailMode, String accessCode) {
		// TODO Auto-generated method stub
		return patientrepo.findById(id).get();
	}

	
//
//	public Patient updatepatient(Patient patient, Long id) {
//		
//
//		Patient patientdb = patientrepo.findById(id).get();
//		
//		
//		if(Objects.nonNull(patient.getFirstName()) && !"".equalsIgnoreCase(patient.getFirstName())) {
//			
//			patientdb.setFirstName(patient.getFirstName());
//		}
//
//
//		return patientrepo.save(patientdb);	
//	}

	public void delete(Long id) {
		
		patientrepo.deleteById(id);
	}



	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientrepo.save(patient);
	}

	
}