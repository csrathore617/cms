package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Diagnosis;


public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer>  {

}
