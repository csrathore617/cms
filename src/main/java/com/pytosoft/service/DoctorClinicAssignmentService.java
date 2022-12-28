package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.scheduling.DoctorClinicAssignment;
import com.pytosoft.repository.DoctorClinicAssignmentRepository;

@Service
public class DoctorClinicAssignmentService {

	@Autowired
	private DoctorClinicAssignmentRepository doctorClinicAssignmentRepository;
	
	public List<DoctorClinicAssignment> findByDoctorAndClinic(DoctorClinicAssignment doctorClinicAssignment)
	{
		return doctorClinicAssignmentRepository.findByDoctorAndClinic(doctorClinicAssignment.getDoctor(), doctorClinicAssignment.getClinic());
		
	}
	public List<DoctorClinicAssignment> findByDoctor(DoctorClinicAssignment doctorClinicAssignment)
	{
		return doctorClinicAssignmentRepository.findByDoctor(doctorClinicAssignment.getDoctor());
		
	}
	public List<DoctorClinicAssignment> findByClinic(DoctorClinicAssignment doctorClinicAssignment)
	{
		return doctorClinicAssignmentRepository.findByClinic( doctorClinicAssignment.getClinic());
		
	}
	
	public List<DoctorClinicAssignment> findAll()
	{
		return doctorClinicAssignmentRepository.findAll();
		
	}
	
	public DoctorClinicAssignment findById(Long id)
	{
		return doctorClinicAssignmentRepository.findById(id).get();
		
	}
	
	public void save(DoctorClinicAssignment doctorClinicAssignment)
	{
		doctorClinicAssignment.setDoctor(null);
		 doctorClinicAssignmentRepository.save(doctorClinicAssignment);
		
	}
	
	public void deleteById(Long id)
	{
		 doctorClinicAssignmentRepository.deleteById(id);
		
	}
	
//	public void update(Long id,DoctorClinicAssignment doctorClinicAssignment)
//	{
//		 
//		
//	}
}
