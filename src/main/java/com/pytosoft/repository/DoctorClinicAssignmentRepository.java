package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.scheduling.DoctorClinicAssignment;

public interface DoctorClinicAssignmentRepository extends JpaRepository<DoctorClinicAssignment, Long> {

	public List<DoctorClinicAssignment> findByDoctorAndClinic(Doctor doctor,Clinic clinic);
	
	public List<DoctorClinicAssignment> findByDoctor(Doctor doctor);
	
	public List<DoctorClinicAssignment> findByClinic(Clinic clinic);
}
