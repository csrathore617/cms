package com.pytosoft.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.pytosoft.model.Immunization;
import com.pytosoft.service.ImmunizationService;

@RestController
@RequestMapping("/immunizationApi")
public class ImmunizationController {

	@Autowired
	private ImmunizationService immunizationService;

	@GetMapping("/immunization")
	public ResponseEntity<?> getImmunization() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		List<Immunization> immunizationList = immunizationService.getImmunization();
		if (!immunizationList.isEmpty()) {
			map.put("status", 1);
			map.put("data", immunizationList);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveImmunization(@RequestBody Immunization immunization) {
		Map<String, Object> map = new LinkedHashMap<>();
		immunizationService.save(immunization);
		map.put("status", 1);
		map.put("message", "Record is Saved Successfully");
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/immunizationHistory/{id}")
	public ResponseEntity<?> getImmunizationById(@PathVariable("id") Short id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		Immunization immunization = immunizationService.findById(id);
		map.put("status", 1);
		map.put("data", immunization);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteImmunizationHistory(@PathVariable Short id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		Immunization immunization = immunizationService.findById(id);
		immunizationService.delete(immunization);
		map.put("status", 1);
		map.put("message", "Record is Deleted Successfully!");
		return new ResponseEntity<>(map, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateImmunizationById(@PathVariable Short id,
			@RequestBody Immunization immunizationDetail) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		Immunization immunization = immunizationService.findById(id);

		immunization.setName(immunizationDetail.getName());
		immunizationService.save(immunization);
		map.put("status", 1);
		map.put("data", immunizationService.findById(id));
		return new ResponseEntity<>(map, HttpStatus.OK);

	}
}
