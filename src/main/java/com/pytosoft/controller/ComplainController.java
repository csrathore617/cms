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

import com.pytosoft.model.Complain;
import com.pytosoft.service.ComplainService;

@RestController
@RequestMapping("/complain")
public class ComplainController {
	@Autowired
	private ComplainService complainService;

	@GetMapping("/getAll")
	public List<Complain> getAllComplain() {
		return complainService.listAll();
	}

	@PostMapping("/addComplain")
	public ResponseEntity<String> add(@RequestBody Complain complain) {
		complainService.save(complain);
		return new ResponseEntity<String>("new complain Added",HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Complain> getComplainById(@PathVariable Integer id) {
		try {
			Complain complain = complainService.getByID(id);
			complainService.save(complain);
			return new ResponseEntity<Complain>(complain, HttpStatus.NOT_FOUND);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Complain>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/comp/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		complainService.deleteComplain(id);
		return new ResponseEntity<String>("complain deleted",HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/obcomp/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		complainService.deleteObservedComplain(id);
		return new ResponseEntity<String>("observed complain deleted",HttpStatus.NOT_FOUND);
	}
}
