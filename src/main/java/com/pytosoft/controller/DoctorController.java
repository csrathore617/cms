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

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/doctors")
public class DoctorController 
{
	@Autowired
	private DoctorService doctorService;
	
	
	@GetMapping("/allDoctors")
	@ResponseBody
	public ResponseEntity<List<Doctor>> getAll(HttpServletRequest request)
	{
		return new ResponseEntity<List<Doctor>>( doctorService.findAll(),HttpStatus.OK);
	}
	
	@PutMapping("/updateDoctor/{doc}")
	public ResponseEntity<Doctor> updateWithId(@PathVariable(name = "docId") Doctor doc){
		Doctor doctor =	doctorService.findById(doc.getId());
			
	return new ResponseEntity<Doctor>(doctorService.save(doctor),HttpStatus.ACCEPTED);
			
	} 
	
	
	@PostMapping("/saveDoc")
	public String saveDoc(@RequestBody Doctor doctor) {
		doctorService.save(doctor);
		return "saved"+ doctor.getDoctorName();
		
	}

	@GetMapping(params = "detail=Thin")
	@ResponseBody
	public ResponseEntity<List<Doctor>> getAllWithBasicDetail(
			@RequestParam(value = "city", required = false) String cityName)
	{
		
		return new ResponseEntity<List<Doctor>>( HttpStatus.OK);
	}
	
	@GetMapping(params = "find=byName")
	public ResponseEntity<List<Doctor>> searchByName(@RequestParam Doctor doctor) {/*String doctorName)*/
		List<Doctor> doctors = new ArrayList<Doctor>();
				doctors.add(doctorService.getEntity(doctor));
		
        return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}

	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<List<Doctor>> getByName(@PathVariable(name = "name") String name){
		return new ResponseEntity<List<Doctor>>(doctorService.findByName(name),HttpStatus.OK);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/delete/{DocId}/{docName}")
	public ResponseEntity<?> Delete(@PathVariable(name = "DocId") Long docId,@PathVariable(name = "docName")String docName) {
		
		
		if(docId!=null&& !docId.equals(0L)) {
			doctorService.deleteById(docId);
			System.out.println("deleted by id");
		}
		else if(docName!=null&&!docName.isEmpty()) {
			Doctor doc =doctorService.findByName(docName).get(0);
				doctorService.deleteById(doc.getId());
				System.out.println("deleted by id");
		}
		return new ResponseEntity("Deleted",HttpStatus.OK);
		
	}
	
	@GetMapping("/getCountByName/{doctorName}")
	public ResponseEntity<Long> getCount(@PathVariable(name = "doctorName")String doctorName) {
		return new ResponseEntity<Long>(doctorService.getCoundByName(doctorName),HttpStatus.OK);
	}
	
	@GetMapping("/lockForDoctor/{doctorName}")
	public ResponseEntity<String> avilableDoctor(@PathVariable(name = "doctorName")String doctorName){
		Boolean avilable = doctorService.exists(doctorName);
		String ans = (avilable) ? "Doctor Is associated with us":"Sorry doctor is associated with us " ;
		return new ResponseEntity<String>(ans, HttpStatus.IM_USED );
	}
	@GetMapping("/count")
	public ResponseEntity<Long> getCompleteCount(){
		return new ResponseEntity<Long>(doctorService.getCount(),HttpStatus.ACCEPTED);
	}
}




