package com.pytosoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pytosoft.model.DegreePassed;
import com.pytosoft.model.Doctor;
import com.pytosoft.repository.custom.CustomDoctorRepo;


public interface DoctorRepository extends JpaRepository<Doctor, Long>,CustomDoctorRepo {
	
	Optional<Doctor> findByDoctorName(String doctorName);
	
	
	boolean existsByDoctorName(String doctorName);
	
	Optional<Long> countByDoctorName(String doctorName);
	
	void deleteByDoctorName(String doctorName);
	
//	ListResponse findAllByClinic(Doctor doctor, Clinic clinic);
	@Query("select dp from DegreePassed dp where id = ?1 ")
	DegreePassed findByDegreePassedId(Long id);
	
	@Modifying 
	@Query("delete from DegreePassed dp where dp.id =?1")
	void deleteDegreePassedById(Long id);

	@Modifying 
	@Query("delete from Expertise e where e.id =?1")
	void deleteExpertise(Long id);
}
