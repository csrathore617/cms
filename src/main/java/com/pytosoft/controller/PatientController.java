package com.pytosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pytosoft.constants.DetailMode;
import com.pytosoft.model.GiqliParamValue;
import com.pytosoft.model.Patient;
import com.pytosoft.service.PatientService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/patient")
public class PatientController// extends BaseController
{

	@Autowired
	private PatientService patientService;

	@PostMapping("/patientassignments")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient saved = patientService.savePatient(patient);
		return new ResponseEntity<Patient>(saved,HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Patient> get(HttpServletRequest request, @PathVariable Long id,
			@RequestParam(required = false) DetailMode detailMode, @RequestParam(required = false) String accessCode)
	{
		Patient patient = patientService.getPatientById(id, detailMode, accessCode);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
//
//	@PutMapping("/patient/{id}")
//	public Patient updatepatient(@RequestBody Patient patient,@PathVariable("id") Long id) {
//		return patientService.updatepatient(patient, id);
//		
//	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		patientService.delete(id);
	return new ResponseEntity<String>("deleted"+id,HttpStatus.OK);
	}

}
