package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Complain;
import com.pytosoft.repository.ComplainRepository;
import com.pytosoft.repository.ObservedComplainRepository;

@Service
public class ComplainService {
    @Autowired
	private ComplainRepository complainRepository;
    
    @Autowired
    private ObservedComplainRepository observedComplainRepository;
    
	public List<Complain> listAll() {
		return complainRepository.findAll();
	}

	public void save(Complain complain) {
		complainRepository.save(complain);
	}

	public Complain getByID(Integer id) {
		return complainRepository.findById(id).get();
	}

	public void deleteComplain(Integer id) {
		complainRepository.deleteById(id);
	}
	
	public void deleteObservedComplain(Long id)
	{
		// add a check with exception ????
		
		observedComplainRepository.deleteById(id);
	}
}
