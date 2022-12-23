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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pytosoft.model.Drug;
import com.pytosoft.service.DrugService;


@RestController
@RequestMapping("/drugs")
public class DrugController
{
	@Autowired
	private DrugService drugService;
	
	@GetMapping("/getAll")
	public List<Drug> list() {
		return drugService.listAll();
	}
	@PostMapping("/add")
	public String add(@RequestBody Drug drug) {
        drugService.save(drug);
		return " Added";
	}
	@GetMapping("/{id}")
	public ResponseEntity<Drug> get(@PathVariable Long id) {

		try {
			Drug drug = drugService.getById(id);
			drugService.save(drug);
			return new ResponseEntity<Drug>(drug, HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Drug>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {

		drugService.delete(id);
		return " Deleted successfully"+id;
	}

	@PutMapping("/update")
	public Drug update(@RequestBody Drug drug){
		return drugService.update(drug);
		
	}
}



