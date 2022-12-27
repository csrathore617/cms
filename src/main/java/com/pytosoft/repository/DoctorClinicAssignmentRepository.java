package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.scheduling.DoctorClinicAssignment;

public interface DoctorClinicAssignmentRepository extends JpaRepository<DoctorClinicAssignment, Long> {

	List<DoctorClinicAssignment> findByDoctorAndClinic(Doctor doctor,Clinic clinic);
	
	List<DoctorClinicAssignment> findByDoctor(Doctor doctor);
	
	List<DoctorClinicAssignment> findByClinic(Clinic clinic);
}
