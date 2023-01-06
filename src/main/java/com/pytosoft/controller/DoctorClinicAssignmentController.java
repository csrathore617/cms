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

import com.pytosoft.model.scheduling.DoctorClinicAssignment;
import com.pytosoft.service.DoctorClinicAssignmentService;

@RestController
@RequestMapping("/DoctorClinicAssignment")
public class DoctorClinicAssignmentController {

	@Autowired
	private DoctorClinicAssignmentService doctorClinicAssignmentService;

	@GetMapping("/getAll")
	public ResponseEntity<List<DoctorClinicAssignment>> getAll() {
		return new ResponseEntity<List<DoctorClinicAssignment>>(doctorClinicAssignmentService.findAll(),HttpStatus.OK);

	}
	
	@GetMapping("/getAll/{docId}")
	public ResponseEntity<List<DoctorClinicAssignment>> findByDoctor(@PathVariable Long docId)
	{
		
	  return new ResponseEntity<List<DoctorClinicAssignment>>(doctorClinicAssignmentService.findAllByDoctor(docId),HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<DoctorClinicAssignment> getById(@PathVariable Long id) {
		
			DoctorClinicAssignment doctorClinicAssignment = doctorClinicAssignmentService.findById(id);

			return new ResponseEntity<DoctorClinicAssignment>(doctorClinicAssignment, HttpStatus.OK);
		
	}

	@PostMapping("/add/{docId}/{clinicId}")
	public void save(@RequestBody List<DoctorClinicAssignment> listOfDoctorClinicAssignment, @PathVariable Long docId, @PathVariable Integer clinicId) {
		doctorClinicAssignmentService.save(listOfDoctorClinicAssignment,docId,clinicId);

	}
	
	

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		doctorClinicAssignmentService.deleteById(id);

	}
}
