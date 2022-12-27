package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Complain;

public interface ComplainRepository extends JpaRepository<Complain, Integer> {
	
}
