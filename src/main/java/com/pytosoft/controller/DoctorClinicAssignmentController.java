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
	public List<DoctorClinicAssignment> getAll() {
		return doctorClinicAssignmentService.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<DoctorClinicAssignment> getById(@PathVariable Long id) {
		try {
			DoctorClinicAssignment doctorClinicAssignment = doctorClinicAssignmentService.findById(id);
			doctorClinicAssignmentService.save(doctorClinicAssignment);

			return new ResponseEntity<DoctorClinicAssignment>(doctorClinicAssignment, HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<DoctorClinicAssignment>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addDoctorClinicAssignment")
	public void save(@RequestBody DoctorClinicAssignment doctorClinicAssignment) {
		doctorClinicAssignmentService.save(doctorClinicAssignment);

	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		doctorClinicAssignmentService.deleteById(id);

	}
}
