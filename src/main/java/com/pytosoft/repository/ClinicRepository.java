package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pytosoft.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

	@Query(value = "select c.* from cms.clinic c inner join cms.doctor_clinic_assignment dca on c.id = dca.clinic_id where dca.doctor_id=:docId",nativeQuery = true)
	public List<Clinic> getByDoctorId(@Param("docId") Long docId);
	
	@Query(value = "select c.* from cms.clinic c inner join cms.visit v on c.id = v.clinic_id inner join cms.medical_case m on v.medical_case_id = m.id   where m.patient_id=:patientId",nativeQuery = true)
	public List<Clinic> getByPatientId(@Param("patientId") Long patientId);
	
	@Query(value = "select c.* from cms.clinic c inner join cms.visit v on c.id = v.clinic_id inner join cms.medical_case m on v.medical_case_id = m.id   where m.doctor_id =:docId, m.patient_id = :patientId",nativeQuery = true)
	public List<Clinic> getByDoctorIdAndPatientId(@Param("docId") Long docId,@Param("patientId") Long patientId);
}
