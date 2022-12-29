package com.pytosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.FollowUp;
import com.pytosoft.service.FollowUpService;

@RestController
@RequestMapping("/followups")
public class FollowUpController {
	@Autowired
	private FollowUpService followUpService;

	@GetMapping("/getAll")
	public List<FollowUp> list() {
		return followUpService.listAll();
	}

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody FollowUp followUp) {
		followUpService.add(followUp);
		return new ResponseEntity<String>("added", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FollowUp> get(@PathVariable Long id) {

		FollowUp followUp = followUpService.getFollowUpById(id);
		followUpService.add(followUp);
		return new ResponseEntity<FollowUp>(followUp, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {

		followUpService.deleteById(id);
		return new ResponseEntity<String>("deleted successfully" + id, HttpStatus.OK);
	}
	
	@PutMapping("/adddoctorbyid/{id}/followupid/{followupid}")
	 public ResponseEntity<FollowUp>addDoctor(@PathVariable(name = "id") Long id,@PathVariable(name = "followupid")Long followUpId){
		Doctor doctor = followUpService.findDoctorById(id);
		FollowUp followUp=   followUpService.addDoctorById(followUpId, doctor);
		return new ResponseEntity<FollowUp>(followUp,HttpStatus.OK);
		
	}
}