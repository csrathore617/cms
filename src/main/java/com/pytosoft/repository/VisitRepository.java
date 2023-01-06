package com.pytosoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.MedicalCase;
import com.pytosoft.model.Referral;
import com.pytosoft.model.ReferredVisit;
import com.pytosoft.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

//	Visit findByName(String Visit);

	Optional<Visit> findById(Long visitId);

//	@Query("select m.doctorId from MedicalCase m where m.doctorId = doctorId ")
	List<MedicalCase> findByMedicalCaseId(Integer medicalCaseId);
	
	
	List<MedicalCase> findByMedicalCaseDoctorID(Long doctorId);
	
	Optional<Visit> findByMedicalCase(MedicalCase medicalCase);
	
	@Query(value ="SELECT rv FROM ReferredVisit rv WHERE rv.visit = :visitPassed")
	Optional<ReferredVisit> findByVisitId(Visit visitPassed);
	
	@Query(value ="SELECT r FROM Referral r WHERE r.medicalCase = :medicalCasePassed AND r.referredTo = :referredToPassed ")
	Optional<Referral> findByReferredVisit(MedicalCase medicalCasePassed, Doctor referredToPassed);
	
//	Visit findByPatient(Long id);

//	Visit findByDoctor(Doctor doctor);
	
//	Visit findByPatient(Patient patient);

}
