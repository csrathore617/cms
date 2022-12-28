package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.scheduling.DoctorClinicAssignment;
import com.pytosoft.repository.ClinicRepository;
import com.pytosoft.repository.DoctorClinicAssignmentRepository;
import com.pytosoft.repository.DoctorRepo;

@Service
public class DoctorClinicAssignmentService {

	@Autowired
	private DoctorClinicAssignmentRepository doctorClinicAssignmentRepository;
	
	@Autowired
	private DoctorRepo doctorRepository;
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	public List<DoctorClinicAssignment> findByDoctorAndClinic(Long docId,Integer clinicId)
	{
		Doctor doctor = doctorRepository.findById(docId).get();
        Clinic clinic = clinicRepository.findById(clinicId).get();
        
		return doctorClinicAssignmentRepository.findByDoctorAndClinic(doctor, clinic);
		
	}
	
	public List<DoctorClinicAssignment> findByDoctor(Long docId)
	{
		Doctor doctor = doctorRepository.findById(docId).get();
		return doctorClinicAssignmentRepository.findByDoctor(doctor);
		
	}
	public List<DoctorClinicAssignment> findByClinic(Integer clinicId)
	{
		Clinic clinic = clinicRepository.findById(clinicId).get();
		return doctorClinicAssignmentRepository.findByClinic(clinic);
		
	}
	
	public List<DoctorClinicAssignment> findAll()
	{
		return doctorClinicAssignmentRepository.findAll();
		
	}
	
	public DoctorClinicAssignment findById(Long id)
	{
		return doctorClinicAssignmentRepository.findById(id).get();
		
	}
	
	public void save(DoctorClinicAssignment doctorClinicAssignment,Long docId,Integer clinicId)
	{
	   Doctor doctor = doctorRepository.findById(docId).get();
	   Clinic clinic = clinicRepository.findById(clinicId).get();
		
		doctorClinicAssignment.setDoctor(doctor);
		doctorClinicAssignment.setClinic(clinic);
		
		 doctorClinicAssignmentRepository.save(doctorClinicAssignment);
		
	}
	
	public void deleteById(Long id)
	{
		DoctorClinicAssignment doctorClinicAssignment = doctorClinicAssignmentRepository.findById(id).get();
		doctorClinicAssignment.setActive(false);
		
		doctorClinicAssignmentRepository.save(doctorClinicAssignment);
		
	}
	
//	public void update(Long id,DoctorClinicAssignment doctorClinicAssignment)
//	{
//		 
//		
//	}
}
