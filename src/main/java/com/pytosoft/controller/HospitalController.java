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
import org.springframework.web.bind.annotation.RestController;

import com.pytosoft.model.Hospital;
import com.pytosoft.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/getAll")
	public List<Hospital> list()
	{
		return hospitalService.listAll();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Hospital hospital)
	{
		hospitalService.save(hospital);
		return "saved successfully";
	}
	
	@DeleteMapping("/{Id}")
	public String delete(@PathVariable Integer Id)
	{
		hospitalService.deleteById(Id);
		return "Deleted Successfully";
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Hospital> getById(@PathVariable Integer Id)
	{
		try {
			
			Hospital hospital=hospitalService.getById(Id);
			hospitalService.save(hospital);
			return new ResponseEntity<Hospital>(hospital, HttpStatus.NOT_FOUND);
		} catch(NoSuchElementException noSuchElementException) {
			return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
		}
	}
	
}
