package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
