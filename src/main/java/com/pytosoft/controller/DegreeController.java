package com.pytosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pytosoft.constants.DegreeType;
import com.pytosoft.model.Degree;
import com.pytosoft.service.DegreeService;

@RestController
@RequestMapping("/degrees")
public class DegreeController {

	@Autowired
	private DegreeService degreeService;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping("/getAll")
	public ResponseEntity<List<Degree>> getAll() {

		return new ResponseEntity<List<Degree>>(degreeService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody List<Degree> degree) {

		degreeService.save(degree);

		return new ResponseEntity<String>("Saved Successfully", HttpStatus.OK);

	}

//	@DeleteMapping("/{Id}")
//	public ResponseEntity<String> delete(@PathVariable(name = "Id") Short id) {
//		degreeService.deleteById(id);
//		return new ResponseEntity<String>("delete Successfully", HttpStatus.OK);
//	}

	@GetMapping("/{Id}")
	public ResponseEntity<Degree> getById(@PathVariable("Id") Short id) {

		Degree degree = degreeService.getById(id);
//			degreeService.save(degree);
		return new ResponseEntity<Degree>(degree, HttpStatus.OK);
	}

	@GetMapping("/getBy/{degreeType}")
	public ResponseEntity<List<Degree>> getByDegreeType(@PathVariable("degreeType") DegreeType degreeType) {
		List<Degree> degreeType1 = degreeService.getByDegreeType(degreeType);
		// System.out.println(degreeType1);
		return new ResponseEntity<List<Degree>>(degreeType1, HttpStatus.FOUND);
	}
}
