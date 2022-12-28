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

import com.pytosoft.model.AllergentType;
import com.pytosoft.service.AllergentTypeService;

@RestController
@RequestMapping("/allergentTypeApi")
public class AllergentTypeController {
	@Autowired
	private AllergentTypeService allergentTypeService;

	@GetMapping("/allergentType")
	public ResponseEntity<?> getAllergentType() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		List<AllergentType> allergentTypesList = allergentTypeService.getAllergentType();
		if (!allergentTypesList.isEmpty()) {
			map.put("status", 1);
			map.put("data", allergentTypesList);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveAllergentType(@RequestBody AllergentType allergentType) {
		Map<String, Object> map = new LinkedHashMap<>();
		allergentTypeService.save(allergentType);
		map.put("status", 1);
		map.put("message", "Record is Saved Successfully");
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/allergentType/{id}")
	public ResponseEntity<?> getAllergentTypeById(@PathVariable("id") Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		AllergentType allergentType = allergentTypeService.findById(id);
		map.put("status", 1);
		map.put("data", allergentType);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAllergentType(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		AllergentType allergentType = allergentTypeService.findById(id);
		allergentTypeService.delete(allergentType);
		map.put("status", 1);
		map.put("message", "Record is Deleted Successfully!");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateAllergentTypeById(@PathVariable Integer id,
			@RequestBody AllergentType allergentTypeDetail) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		AllergentType allergentType = allergentTypeService.findById(id);

		allergentType.setName(allergentTypeDetail.getName());
		allergentTypeService.save(allergentType);
		map.put("status", 1);
		map.put("data", allergentTypeService.findById(id));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
