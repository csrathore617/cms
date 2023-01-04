package com.pytosoft.controller;

import java.util.List;

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
	public ResponseEntity<List<Clinic>> getAllClinics() {
		return new ResponseEntity<List<Clinic>>(clinicService.getAllClinic(), HttpStatus.OK);
	}

	@GetMapping("/getAll/{doctorId}")
	public ResponseEntity<List<Clinic>> findAllByDoctor(@PathVariable Long doctorId) {
		return new ResponseEntity<List<Clinic>>(clinicService.findAllByDoctor(doctorId), HttpStatus.OK);
	}

//	@GetMapping("/getAll/{patientId}")
//	public ResponseEntity<List<Clinic>> findAllByPatient(@PathVariable Long patientId) {
//		return new ResponseEntity<List<Clinic>>(clinicService.findAllByPatient(patientId), HttpStatus.OK);
//	}
//
//	@GetMapping("/getAll/{doctorId}/{patientId}")
//	public ResponseEntity<List<Clinic>> findAllByDoctorAndPatient(@PathVariable Long doctorId,@PathVariable Long patientId) {
//		return new ResponseEntity<List<Clinic>>(clinicService.findAllByDoctorAndPatient(doctorId, patientId),
//				HttpStatus.OK);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Clinic> getByIdClinic(@PathVariable Integer id) {
		Clinic clinic = clinicService.findById(id);

		return new ResponseEntity<Clinic>(clinic, HttpStatus.OK);

	}

	@PostMapping("/addclinic/{doctorId}/{patientId}")
	public void saveClinic(@RequestBody Clinic clinic,@PathVariable Long doctorId,@PathVariable Long patientId) {
		clinicService.saveClinic(clinic,doctorId,patientId);
	}

	@DeleteMapping("/{id}")
	public void deleteClinic(@PathVariable Integer id) {
		clinicService.deleteClinic(id);
	}
}
