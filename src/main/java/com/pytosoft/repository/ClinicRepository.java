package com.pytosoft.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;
import com.pytosoft.model.scheduling.DoctorClinicAssignment;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

//	public List<Clinic> findByDoctor(Doctor doctor);
//	
//	public List<Clinic> findByPatient(Patient patient);
//	
//	public List<Clinic> findByDoctorAndPatient(Doctor doctor,Patient patient);
	
	@Query(value ="SELECT c.* FROM cms.clinic c inner join cms.doctor_clinic_assignment dca on c.id=dca.clinic_id where dca.doctor_id= :docId ", nativeQuery = true)
	public List<Clinic> findById(@Param("docId") Long docId); 
	
}
	