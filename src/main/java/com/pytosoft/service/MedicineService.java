package com.pytosoft.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.protocol.Resultset;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Drug;
import com.pytosoft.model.FavoriteMedicine;
import com.pytosoft.model.Medicine;
import com.pytosoft.repository.DoctorRepository;
import com.pytosoft.repository.DrugRepository;
import com.pytosoft.repository.MedicineRepository;

@Service
@Transactional
public class MedicineService {
	@Autowired
	private MedicineRepository medicineRepository;

	@Autowired
	private DrugRepository drugRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	public List<Medicine> listAll() {
		return medicineRepository.findAll();
	}

	public void save(Medicine medicine) {
		medicineRepository.save(medicine);
	}

	public Medicine findByID(Long id) {
		return medicineRepository.findById(id).get();
	}

	public void delete(Long id) {
		Medicine medicine = medicineRepository.findById(id).get();
		medicine.setIsActive(false);
		medicineRepository.save(medicine);
	}

	public List<Medicine> findByDrug(Long id) {
		Drug drug = drugRepository.findById(id).get();
		return medicineRepository.findByDrug(drug);
	}

	public List<Medicine> findByDoctor(Long id) {
		Doctor doctor = doctorRepository.findById(id).get();
		return medicineRepository.findByDoctor(doctor);
	}

	@SuppressWarnings("null")
	public List<FavoriteMedicine> findFavoriteMedicineByDoctor(Long id) {
		Doctor doctor = doctorRepository.findById(id).get();
		List<FavoriteMedicine> favoriteMedicineList = new ArrayList<>();
		List<Medicine> medicine = medicineRepository.findByDoctor(doctor);
		Iterator<Medicine> iterator = medicine.iterator();
		while (iterator.hasNext()) {
			FavoriteMedicine favMedicine = iterator.next().getFavoriteMedicine();
			favoriteMedicineList.add(favMedicine);
		}
		return favoriteMedicineList;
	}

}
