package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Hospital;
import com.pytosoft.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> listAll()
	{
		return hospitalRepository.findAll();
	}
	
	public void save(Hospital hospital)
	{
		hospitalRepository.save(hospital);
	}
	
	public Hospital getById(Integer Id)
	{
		return hospitalRepository.findById(Id).get();
	}
	
	public void deleteById(Integer Id)
	{
		hospitalRepository.deleteById(Id);
	}
	
	
}
