package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;
import com.pytosoft.model.Visit;
import com.pytosoft.repository.VisitRepository;

@Service
public class VisitService {

	@Autowired
	private VisitRepository repo;
	
	public List<Visit> findAll() {
		return repo.findAll();
	}

	public Visit save(Visit entity) {

		return repo.save(entity);

	}

	/*
	 * public Visit saveOrUpdate(Visit entity) {
	 * 
	 * repo.findById(entity.getId()); Visit visitUpdate = new Visit(entity.getId(),
	 * entity.getVisitName(), entity.getVisitSpecializations(),
	 * entity.getDegreesPassed(), entity.isAcceptsNewPatient()); return
	 * repo.save(docUpdate);
	 * 
	 * }
	 */
	public Visit getEntity(Visit entity) {
		return repo.findById(entity.getId()).orElse(null);

	}

	public void delete(Visit entity) {
		repo.delete(entity);

	}

	/*
	 * public List<Visit> findByName(String Name) { return repo.getByName(Name); }
	 */

	public Visit findById(Long id) {
		return repo.findById(id).get();
	}

	public void deleteById(Long id) {
		repo.deleteById(id);

	}

	/*
	 * public Long getCoundByName(String VisitName) { return
	 * repo.countByVisitName(VisitName).orElse(0l);
	 * 
	 * }
	 */

	public Boolean exists(Long VisitId) {
		return repo.existsById(VisitId);
	}

	public Long getCount() {
		return repo.count();
	}
//	public Visit findByPatient(Long id) {
//		return repo.findByPatient(id);
//	}
	
//	public Visit findByDoctor(Doctor doctor) {
//		return repo.findByDoctor(doctor);
//	}
//	
//	public Visit findByPatient(Patient patient) {
//		return repo.findByPatient(patient);
//	}
	



	
}
