package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

}
