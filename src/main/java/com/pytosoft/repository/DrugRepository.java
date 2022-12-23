package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Drug;



public interface DrugRepository extends JpaRepository<Drug,Long> {

}
