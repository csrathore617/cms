package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	public List<Hospital> searchByName(String hospitalName);
}
