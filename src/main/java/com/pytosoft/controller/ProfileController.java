package com.pytosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.pytosoft.model.Doctor;
import com.pytosoft.service.DoctorService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class ProfileController
{
	@Autowired
	private DoctorService doctorService;


	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getProfile(@PathVariable Long id)
	{
//		Long userId = WebUtils.getParsedUserId(request);
		Doctor result = doctorService.getDoctor(id);
		return new ResponseEntity<Doctor>(result, HttpStatus.OK);
	}

	@RequestMapping(value="/postprofile",  method = { RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public ResponseEntity<Doctor> saveOrUpdate(@RequestBody Doctor doctor/* , HttpServletRequest request */)
	{
//		doctor.setId(id);
		Doctor saved = doctorService.save(doctor);
		HttpStatus status = doctor.getId() != null ? HttpStatus.OK : HttpStatus.CREATED;
		Doctor newdoc = new Doctor();
		newdoc.setId(saved.getId());
		return new ResponseEntity<Doctor>(newdoc, status);
	}

	@RequestMapping(value = "/{id}/degreepassed/{degreepassedId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDegreePassed(HttpServletRequest request, @PathVariable("id") Long doctorId,
			@PathVariable("degreepassedId") Long degreepassedId)
	{
		
		doctorService.deleteDegreePassed(doctorId, degreepassedId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/expertises/{expertiseId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteExpertise(HttpServletRequest request, @PathVariable("id") Long doctorId,
			@PathVariable("expertiseId") Long expertiseId)
	{
		doctorService.deleteExpertise(doctorId, expertiseId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

//	@RequestMapping(value = "/profilePic", method = RequestMethod.POST)
//	public ResponseEntity<UploadedFile> saveProfilePic(@RequestParam(value = "file", required = true) MultipartFile file)
//	{
//		this.validate(file);
//		UploadedFile fileName = appUserService.saveProfilePic(file);
//		return new ResponseEntity<UploadedFile>(fileName, HttpStatus.OK);
//	}
}
