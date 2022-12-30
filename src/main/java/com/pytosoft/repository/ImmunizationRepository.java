package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Immunization;

public interface ImmunizationRepository extends JpaRepository<Immunization, Short> {

	public List<Immunization> findByName(String name);
}
