package com.pytosoft.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pytosoft.model.Doctor;
import com.pytosoft.service.DoctorService;
import com.pytosoft.vo.ListResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/allDoctors")
	@ResponseBody
	public ResponseEntity<ListResponse> getAll(HttpServletRequest request) {
		ListResponse result = doctorService.findAll();
		return new ResponseEntity<ListResponse>(result, HttpStatus.OK);
	}

	@PutMapping("/updateDoctor/{doc}")
	public ResponseEntity<Doctor> updateWithId(@PathVariable(name = "docId") Doctor doc) {
		Doctor doctor = doctorService.findById(doc.getId());

		return new ResponseEntity<Doctor>(doctorService.save(doctor), HttpStatus.ACCEPTED);

	}

	@PostMapping("/saveDoc")
	public String saveDoc(@RequestBody Doctor doctor) {
		doctorService.save(doctor);
		return "saved" + doctor.getDoctorName();

	}

	@GetMapping(params = "detail=Thin")
	@ResponseBody
	public ResponseEntity<List<Doctor>> getAllWithBasicDetail(
			@RequestParam(value = "city", required = false) String cityName) {

		return new ResponseEntity<List<Doctor>>(HttpStatus.OK);
	}

	@GetMapping(params = "find=byName")
	public ResponseEntity<List<Doctor>> searchByName(@RequestParam Doctor doctor) {/* String doctorName) */
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors.add(doctorService.getEntity(doctor));

		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}

	@DeleteMapping("/deletedegreepassed/{id}/degreepassedId/{degreepassedId}")
	public ResponseEntity<Object> deleteDegreePassed(@PathVariable("id") Long doctorId,
			@PathVariable("degreepassedId") Long degreepassedId) {
//		Doctor doctor = getLoggedInDoctor(request);
		doctorService.deleteDegreePassed(degreepassedId, doctorId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}/expertises/{expertiseId}")
	public ResponseEntity<Object> deleteExpertise(@PathVariable("id") Long doctorId,
			@PathVariable("expertiseId") Long expertiseId) {
//		Doctor doctor = getLoggedInDoctor(request);
		doctorService.deleteExpertise(expertiseId, doctorId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/findByName/{name}")
	public ResponseEntity<List<Doctor>> getByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<List<Doctor>>(doctorService.findByName(name), HttpStatus.OK);

	}

	@DeleteMapping("/delete/id/{DocId}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable(name = "DocId", required = true) Long docId) {

		doctorService.delete(docId, null);

		return new ResponseEntity<String>("Deleted", HttpStatus.OK);

	}

	@DeleteMapping("/delete/name/{docName}")
	public ResponseEntity<String> deleteDoctorByName(@PathVariable(name = "docName") String docName) {

		doctorService.delete(null, docName);

		return new ResponseEntity<String>("Deleted", HttpStatus.OK);

	}

	@GetMapping("/getCountByName/{doctorName}")
	public ResponseEntity<Long> getCount(@PathVariable(name = "doctorName") String doctorName) {
		return new ResponseEntity<Long>(doctorService.getCoundByName(doctorName), HttpStatus.OK);
	}

	@GetMapping("/lockForDoctor/{doctorName}")
	public ResponseEntity<String> avilableDoctor(@PathVariable(name = "doctorName") String doctorName) {
		Boolean avilable = doctorService.exists(doctorName);
		String ans = (avilable) ? "Doctor Is associated with us" : "Sorry doctor is associated with us ";
		return new ResponseEntity<String>(ans, HttpStatus.IM_USED);
	}

	@GetMapping("/count")
	public ResponseEntity<Long> getCompleteCount() {
		return new ResponseEntity<Long>(doctorService.getCount(), HttpStatus.ACCEPTED);
	}
}
