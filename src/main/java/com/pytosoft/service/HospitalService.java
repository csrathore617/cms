package com.pytosoft.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Address;
import com.pytosoft.model.Country;
import com.pytosoft.model.Hospital;
import com.pytosoft.model.State;
import com.pytosoft.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> getAll() {
		List<Hospital> list = hospitalRepository.findAll();
		Hibernate.initialize(list);
		return list;
	}

	public void save(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public Hospital getById(Integer Id) {
		Hospital hospital = hospitalRepository.findById(Id).get();

		/*
		 * Address address = new Address(); State state = new State(); Country country =
		 * new Country(); // Specialization specialization = new Specialization(); //
		 * HospitalSpecialization hospitalSpecialization = new HospitalSpecialization();
		 * 
		 * // Set<HospitalSpecialization> hospitalSpecializationList = null;
		 * 
		 * BeanUtils.copyProperties(hospital.getAddress(), address);
		 * BeanUtils.copyProperties(hospital.getAddress().getCountry(), country);
		 * BeanUtils.copyProperties(hospital.getAddress().getState(), state); ////
		 * BeanUtils.copyProperties(hospital.getHospitalSpecializations(),
		 * hospitalSpecializationList); ////
		 * BeanUtils.copyProperties(hospital.getHospitalSpecializations(),
		 * specialization); // // address.setState(state); address.setCountry(country);
		 * hospital.setAddress(address); // Hibernate.initialize(hospital);
		 */		return hospital;

	}

	public void deleteById(Integer Id) {
		Hospital hospital = hospitalRepository.findById(Id).get();
		hospital.setIsActive(false);
		hospitalRepository.save(hospital);
	}

	public List<Hospital> searchByName(String hospitalName) {
		List<Hospital> hospital = hospitalRepository.searchByName(hospitalName);
		return hospital;
	}

}
