package com.pytosoft.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.FollowUp;
import com.pytosoft.repository.DoctorRepository;
import com.pytosoft.repository.FollowUpRepository;

@Service
public class FollowUpService {
	@Autowired
	private FollowUpRepository followUpRepository;
	
	@Autowired
	DoctorRepository doctorRepository;

	public List<FollowUp> listAll() {
		return followUpRepository.findAll();
	}

	public FollowUp add(FollowUp followUp) {
		return followUpRepository.save(followUp);
	}

	public FollowUp getFollowUpById(Long id) {
		return followUpRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		followUpRepository.deleteById(id);
	}
	public FollowUp addDoctorById(Long followupId,Doctor doctor) {
		FollowUp followUp = followUpRepository.findById(followupId).get();
		followUp.setFollowedByDoctor(doctor);
		return followUpRepository.save(followUp);
	}

	public Doctor findDoctorById(Long id) {
	
		return doctorRepository.findById(id).get();
	}
}
