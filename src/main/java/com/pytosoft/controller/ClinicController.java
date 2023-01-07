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

	@GetMapping("/getAllByDocId/{DocId}")
	public ResponseEntity<List<Clinic>> findByDocId(@PathVariable Long DocId) {
		return new ResponseEntity<List<Clinic>>(clinicService.findByDocId(DocId), HttpStatus.OK);
	}

	@GetMapping("/getAllByPatientId/{id}")
	public ResponseEntity<List<Clinic>> findByPatientId(@PathVariable Long PatientId) {
		return new ResponseEntity<List<Clinic>>(clinicService.findByPatientId(PatientId),  HttpStatus.OK);
	}

	@GetMapping("/getAllByDocIdAndPatientId/{DocId}/{PatientId}")
	public ResponseEntity<List<Clinic>> findByPatientIdAndDocId(@PathVariable Long DocId, @PathVariable Long PatientId) {
		return new ResponseEntity<List<Clinic>>(clinicService.findByDocIdAndPatientId(DocId, PatientId), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Clinic> getByIdClinic(@PathVariable Integer id) {

		Clinic clinic = clinicService.findById(id);

		return new ResponseEntity<Clinic>(clinic, HttpStatus.OK);

	}

	@PostMapping("/addclinic")
	public ResponseEntity<String> saveClinic(@RequestBody Clinic clinic) {
		clinicService.saveClinic(clinic);
		return new ResponseEntity<String>("clinic save", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClinic(@PathVariable Integer id) {
		clinicService.deleteClinic(id);
		return new ResponseEntity<String>("clinic is set as not active", HttpStatus.OK);
	}
}
