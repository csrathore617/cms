package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pytosoft.model.Medicine;
import com.pytosoft.repository.MedicineRepository;

@Service
@Transactional
public class MedicineService {
	@Autowired
	private MedicineRepository medicineRepo;

	public List<Medicine> listAll() {
		return medicineRepo.findAll();
	}

	public void save(Medicine medicine) {
		medicineRepo.save(medicine);
	}

	public Medicine getByID(Long id) {
		return medicineRepo.findById(id).get();
	}

	public void delete(Long id) {
		medicineRepo.deleteById(id);
	}

}
