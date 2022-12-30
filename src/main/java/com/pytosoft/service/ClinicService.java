package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;
import com.pytosoft.repository.ClinicRepository;
import com.pytosoft.repository.DoctorRepository;
import com.pytosoft.repository.PatientRepository;

@Service

public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Clinic> getAllClinic()
	{
		return clinicRepository.findAll();
	}
	
	public Clinic findById(Integer id)
	{
		return clinicRepository.findById(id).get();
	}
	
	public List<Clinic> findAllByDoctor(Long doctorId)
	{
		Doctor doctor = doctorRepository.findById(doctorId).get();
		return clinicRepository.findByDoctor(doctor);
	}
	
	public List<Clinic> findAllByPatient(Long PatientId)
	{
		Patient patient = patientRepository.findById(PatientId).get();
		return clinicRepository.findByPatient(patient);
	}
	
	public List<Clinic> findAllByDoctorAndPatient(Long doctorId,Long PatientId)
	{
		Doctor doctor = doctorRepository.findById(doctorId).get();
		Patient patient = patientRepository.findById(PatientId).get();
		
		return clinicRepository.findByDoctorAndPatient(doctor, patient);
	}
	
	public void saveClinic(Clinic clinic)
	{
		clinicRepository.save(clinic);
	}
	

	public void deleteClinic(Integer id)
	{
	  Clinic clinic = clinicRepository.findById(id).get();
	  clinic.setActive(false);
	  
	  clinicRepository.save(clinic);
	}
	

	
}
