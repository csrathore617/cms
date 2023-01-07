package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Clinic;
import com.pytosoft.repository.ClinicRepository;

@Service

public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;

	public List<Clinic> getAllClinic() {
		return clinicRepository.findAll();
	}

	public List<Clinic> findByDocId(Long docId) {
		return clinicRepository.getByDoctorId(docId);
	}

	public List<Clinic> findByPatientId(Long patientId) {
		return clinicRepository.getByPatientId(patientId);
	}

	public List<Clinic> findByDocIdAndPatientId(Long docId, Long patientId) {
		return clinicRepository.getByDoctorIdAndPatientId(docId, patientId);
	}

	public Clinic findById(Integer id) {
		return clinicRepository.findById(id).get();
	}

	public void saveClinic(Clinic clinic) {
		clinicRepository.save(clinic);
	}

	public void deleteClinic(Integer id) {
		Clinic clinic = clinicRepository.findById(id).get();
		clinic.setActive(false);

		clinicRepository.save(clinic);
	}

}
