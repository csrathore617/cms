package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
