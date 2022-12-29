package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.FollowUp;
import com.pytosoft.repository.DoctorRepo;
import com.pytosoft.repository.FollowUpRepository;


@Service
public class FollowUpService {
	@Autowired
	private FollowUpRepository followUpRepository;
	@Autowired
	DoctorRepo repo;

	
    public List<FollowUp> listAll() {
        return followUpRepository.findAll();
    }
     
    public FollowUp add(FollowUp followUp) {
      return  followUpRepository.save(followUp);
    }
     
    public FollowUp getFollowUpById(Long id) {
        return followUpRepository.findById(id).get();
    }
    
    public void deleteById(Long id) {
        followUpRepository.deleteById(id);
    }
    
    public Doctor findDoctorById(Long id)
	{
		return repo.findById(id).get();
		
	}
    public FollowUp addDoctorById(Long folloupId, Doctor doctor) {
    	FollowUp followUp =followUpRepository.findById(folloupId).get();
    	followUp.setFollowedByDoctor(doctor);
        return followUpRepository.save(followUp);
    }
  }

	

