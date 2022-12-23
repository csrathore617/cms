package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long > {

}
