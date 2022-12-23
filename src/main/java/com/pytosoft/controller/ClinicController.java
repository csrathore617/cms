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

import com.pytosoft.model.Clinic;
import com.pytosoft.service.ClinicService;


@RestController
@RequestMapping("/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;
	
	@GetMapping("/getAll")
	public List<Clinic> getAllClinics()
	{
		return clinicService.getAllClinic();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clinic> getByIdClinic(@PathVariable Integer id)
	{
		try {
		Clinic clinic =	clinicService.findById(id);
		clinicService.saveClinic(clinic);
		
		return new ResponseEntity<Clinic>(clinic,HttpStatus.NOT_FOUND);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Clinic>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addclinic")
	public void saveClinic(@RequestBody Clinic clinic)
	{
		clinicService.saveClinic(clinic);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClinic(@PathVariable Integer id)
	{
		clinicService.deleteClinic(id);
	}
}


