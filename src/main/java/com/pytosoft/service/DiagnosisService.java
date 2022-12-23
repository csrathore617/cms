package com.pytosoft.service;

import com.pytosoft.model.Diagnosis;
import com.pytosoft.repository.DiagnosisRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class DiagnosisService {

	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	public List<Diagnosis> getAllDiagnosis()
	{
		return diagnosisRepository.findAll();
	}
	
	public Diagnosis findById(Integer id)
	{
		return diagnosisRepository.findById(id).get();
	}
	
	public void saveDiagnosis(Diagnosis diagnosis)
	{
		diagnosisRepository.save(diagnosis);
	}
	

	public void deleteDiagnosis(Integer id)
	{
		diagnosisRepository.deleteById(id);
	}
	
//	public void updateDiagnosis(Diagnosis diagnosis)
//	{
//		diagnosisRepository.(diagnosis);
//	}
	
}