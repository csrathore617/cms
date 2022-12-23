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
	
	public List<Clinic> getAllClinic()
	{
		return clinicRepository.findAll();
	}
	
	public Clinic findById(Integer id)
	{
		return clinicRepository.findById(id).get();
	}
	
	public void saveClinic(Clinic clinic)
	{
		clinicRepository.save(clinic);
	}
	

	public void deleteClinic(Integer id)
	{
		clinicRepository.deleteById(id);
	}
	
//	public void updateClinic(Clinic clinic)
//	{
//		clinicRepository.(clinic);
//	}
	
}
