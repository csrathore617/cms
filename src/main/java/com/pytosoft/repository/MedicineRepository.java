package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.Drug;
import com.pytosoft.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	public List<Medicine> findByDoctor(Doctor doctor);

	public List<Medicine> findByDrug(Drug drug);
}
