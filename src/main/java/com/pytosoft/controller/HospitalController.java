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

import com.pytosoft.model.Hospital;
import com.pytosoft.service.HospitalService;
import com.pytosoft.vo.ListResponse;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
//	@GetMapping("/getAll")
//	public ResponseEntity<ListResponse> getAllHospitals()
//	{
//		List<Hospital> result= hospitalService.getAll();
//		return new ResponseEntity<ListResponse> (new ListResponse(result.size(),result.size(),result),HttpStatus.OK);
//	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hospital>> getAllHospitals()
	{
		return new ResponseEntity<List<Hospital>> (hospitalService.getAll(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Hospital hospital)
	{
		hospitalService.save(hospital);
		return new ResponseEntity<String>("saved successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<String> delete(@PathVariable Integer Id)
	{
		
		hospitalService.deleteById(Id);
		return new ResponseEntity<String>("Hospital is not active now",HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Hospital> getById(@PathVariable Integer Id)
	{
			Hospital hospital=hospitalService.getById(Id);
			return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}
	
	@GetMapping("/getBy/{hospitalName}")
	public ResponseEntity<List<Hospital>> searchByName(@PathVariable("hospitalName") String hospitalName)
	{
		List<Hospital> hospital=hospitalService.searchByName(hospitalName);
		return new ResponseEntity<List<Hospital>>(hospital,HttpStatus.OK);
	}
}
