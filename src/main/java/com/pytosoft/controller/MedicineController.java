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

import com.pytosoft.model.Medicine;
import com.pytosoft.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;

	@GetMapping("/getAll")
	public List<Medicine> empList() {
		return medicineService.listAll();
	}

	@PostMapping("/addMedicine")
	public String add(@RequestBody Medicine medicine) {
		medicineService.save(medicine);
		return "new medicine Added";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicine> getEmp(@PathVariable Long id) {
		try {
			Medicine medicine = medicineService.getByID(id);
			medicineService.save(medicine);
			return new ResponseEntity<Medicine>(medicine, HttpStatus.NOT_FOUND);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Medicine>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		medicineService.delete(id);
		return " Employee sucessfully deleted" + id;
	}

}
