package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Doctor;
import com.pytosoft.repository.DoctorRepo;

@Service
public class DoctorService {
	@Autowired
	DoctorRepo repo;

	public List<Doctor> findAll() {
		return repo.findAll();
	}

	public Doctor save(Doctor entity) {

		return repo.save(entity);

	}

	public Doctor saveOrUpdate(Doctor entity) {

		repo.findById(entity.getId());
		Doctor docUpdate = new Doctor(entity.getId(), entity.getDoctorName(), entity.getDoctorSpecializations(),
				entity.getDegreesPassed(), entity.isAcceptsNewPatient());
		return repo.save(docUpdate);

	}

	public Doctor getEntity(Doctor entity) {
		return repo.findById(entity.getId()).orElse(new Doctor("NoSuchDoctor"));

	}

	public void delete(Doctor entity) {
		repo.delete(entity);

	}

	public List<Doctor> findByName(String Name) {
		return repo.getByName(Name);
	}

	public Doctor findById(Long id) {
		return repo.findById(id).get();
	}

	public void deleteById(Long id) {
		repo.deleteById(id);

	}

	public Long getCoundByName(String doctorName) {
		return repo.countByDoctorName(doctorName).orElse(0l);

	}

	public Boolean exists(String doctorName) {
		return repo.existsByDoctorName(doctorName);
	}

	public Long getCount() {
		return repo.count();
	}

	public void deleteDegreePassed(Long doctorId, Long degreepassedId) {
		repo.deleteById(degreepassedId);
		
	}

	public void deleteExpertise(Long doctorId, Long expertiseId) {
		repo.deleteById(expertiseId);
	}

	public Doctor getDoctor(Long id) {
		return repo.findById(id).get();
	}

	

}
