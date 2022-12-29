package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Immunization;

public interface ImmunizationRepository extends JpaRepository<Immunization, Short> {

}
