package com.pytosoft.controller;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pytosoft.model.Diagnosis;
import com.pytosoft.service.DiagnosisService;


@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

	@Autowired
	private DiagnosisService diagnosisService;
	
	@GetMapping("/getAll")
	public List<Diagnosis> getAllDiagnosis()
	{
		return diagnosisService.getAllDiagnosis();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Diagnosis> getByIdDiagnosis(@PathVariable Integer id)
	{
		try {
			Diagnosis diagnosis =	diagnosisService.findById(id);
			diagnosisService.saveDiagnosis(diagnosis);
		
		return new ResponseEntity<Diagnosis>(diagnosis,HttpStatus.NOT_FOUND);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Diagnosis>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/adddiagnosis")
	public String saveDiagnosis(@RequestBody Diagnosis diagnosis)
	{
		diagnosisService.saveDiagnosis(diagnosis);
		return " New disease Added";
	}
	
	@DeleteMapping("/{id}")
	public String deleteDiagnosis(@PathVariable Integer id)
	{
		diagnosisService.deleteDiagnosis(id);
		return " Diagnosis deleted with id " + id;
	}
}


