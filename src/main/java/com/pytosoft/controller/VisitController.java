package com.pytosoft.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;
import com.pytosoft.model.ReferredVisit;
import com.pytosoft.model.Visit;
import com.pytosoft.model.procedure.VisitAttachment;
import com.pytosoft.service.ClinicService;
import com.pytosoft.service.DoctorService;
import com.pytosoft.service.PatientService;
import com.pytosoft.service.VisitService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("visits")
public class VisitController /*extends BaseController*/
{
	@Autowired
	private VisitService visitService;
	
	
	
	@PostMapping("/savevisit/doctor/{doctorId}/patient/{patientId}/clinic/{clinicId}/doctorclinicassignment/{doctorClinicAssignmentId}")
	@ResponseBody
	public ResponseEntity<Visit> create(HttpServletRequest request, @RequestBody Visit visit,
			@PathVariable("doctorId")Long doctorId,@PathVariable("patientId") Long patientId,
			@PathVariable("clinicId")Integer clinicId,@PathVariable("doctorClinicAssignmentId")Long doctorClinicAssignmentId)
	{
		Visit saved = this.visitService.save(visit,doctorId,clinicId,patientId,doctorClinicAssignmentId	);
		return new ResponseEntity<Visit>(saved, HttpStatus.CREATED);
	}
	@GetMapping("/getall")
	@ResponseBody
	public ResponseEntity<List<Visit>> getAll(){
		List<Visit> visitList = visitService.findAll();
		return new ResponseEntity<List<Visit>>(visitList,HttpStatus.OK);
	}

	  
	

	@GetMapping(value = "/findbyid/{visitId}")
	@ResponseBody
	public ResponseEntity<Visit> getById(@RequestParam(required = false) Long patentId,
			@RequestParam(required = false) String detailType, HttpServletRequest request
			,@PathVariable("visitId")Long visitId)
	{
		Visit visit =visitService.findById(visitId);
		
		return new ResponseEntity<Visit>(visit,HttpStatus.OK);
	}
	@GetMapping("find=Referred/{doctorId}")
	@ResponseBody
	public ResponseEntity<ReferredVisit> getReferredVisit(HttpServletRequest request, @PathVariable("doctorId") Long doctorId,
			@RequestParam(required = false) String detailType)
	{
		/*
		 * Doctor doctor = null; Clinic clinic =
		 * getLoggedInClinicForClinicAdmin(request); if (clinic == null) { doctor =
		 * getLoggedInDoctor(request); }
		 */
//		Visit visit = this.visitService.getReferredVisit(visitId, doctor, detailType);
		ReferredVisit referredVisit = visitService.getReferredVisit(doctorId);
		return new ResponseEntity<ReferredVisit>(referredVisit, HttpStatus.OK);
	}

	
	

	@GetMapping("findByDoctorName/{docName}")
	@ResponseBody
	public ResponseEntity<Visit> getByDoctoreId(HttpServletRequest request, @PathVariable("docName") String docName,
			@RequestParam(required = false) String detailType)
	{	
//		String docName = visitService.findById(visitId).getAppointment().getReferredBy();
//		Doctor doctor = doctorService.findByName(docName).get(0);
//		Clinic clinic = getLoggedInClinicForClinicAdmin(request);
//		if (doctor == null)
//		{
//			throw new IllegalArgumentException("'Can't identify doctor'");
//		}
//		Visit	 visit = this.visitService.findByDoctor(doctor);
//		return new ResponseEntity<Visit>(null, HttpStatus.OK);
		return null;
	}
	
//	@GetMapping("/get/clinicid/{clinic_id}/doctorid/{doc_id}/")
//	@ResponseBody
//	public ResponseEntity<Visit> get(@PathVariable("id") Integer visitId,
//			@PathVariable("doc_id")Long docId,@PathVariable("clinic_id")Integer clinicId,@RequestParam(required = false) String detailType)
//	{
//		Doctor doctor = null;
//		Clinic clinic = clinicService.findById(clinicId);
//		if (clinic == null)
//		{
//			doctor = getLoggedInDoctor(request);
//		}
//		VisitVO visit = this.visitService.get(visitId, doctor, detailType);
//		return new ResponseEntity<VisitVO>(visit, HttpStatus.OK);
//	}

//	@GetMapping(value = "/{id}/pdf")
//	@ResponseBody
//	public ResponseEntity<Object> sendPDFAsEmail(HttpServletRequest request, @PathVariable("id") Integer visitId, @RequestParam String email)
//	{
//
//		File directory = (File) request.getSession().getServletContext().getAttribute("javax.servlet.context.tempdir");
//		Doctor doctor = getLoggedInDoctor(request);
//		this.visitService.sendPDFAsEmail(visitId, doctor, directory, email);
//		return new ResponseEntity<Object>(HttpStatus.OK);
//	}

	@GetMapping("/findByPatient/{patientId}")
	@ResponseBody
	public ResponseEntity<Visit> getAllByPatient(@RequestParam("patientId") Long patientId)
	{
//		Patient patient = patientService.getPatientById(patientId, null, null);
//		if (patient == null)
//		{
//			throw new IllegalArgumentException("'Can't identiy patient'");
//		}
////		Visit result = visitService.findByPatient(patient);
		
//		return new ResponseEntity<Visit>(result, HttpStatus.OK);
		return null;
	}

	/*
	 * @GetMapping(value = "/attachment")
	 * 
	 * public ResponseEntity<VisitAttachment> saveFileUploaded(
	 * 
	 * @RequestParam(value = "file", required = true) MultipartFile file,
	 * 
	 * @RequestParam(required = true) Long patientId, @RequestParam(required = true)
	 * Long medicalCaseId,
	 * 
	 * @RequestParam(required = true) String title, @RequestParam(required = true)
	 * String notes,
	 * 
	 * @RequestParam(required = true) String captureOn, HttpServletRequest request)
	 * { Doctor doctor = getLoggedInDoctor(request); VisitAttachment fileName =
	 * visitService.saveFileUploaded(file, doctor, patientId, medicalCaseId, title,
	 * notes, captureOn); return new ResponseEntity<VisitAttachment>(fileName,
	 * HttpStatus.OK); }
	 */

	/*
	 * @DeleteMapping(value = "/attachment/{id}") public ResponseEntity<Object>
	 * deleteFileAttachment(HttpServletRequest request, @PathVariable Long id) {
	 * visitService.deleteAttachmentFile(id); return new
	 * ResponseEntity<Object>(HttpStatus.OK); }
	 * 
	 * @PostMapping(value = "/investigation/attachment") public
	 * ResponseEntity<UploadedFile> saveInvestigationFileUploaded(
	 * 
	 * @RequestParam(value = "file", required = true) MultipartFile file) {
	 * UploadedFile uploadedFile = visitService.saveInvestigationFileUploaded(file);
	 * return new ResponseEntity<UploadedFile>(uploadedFile, HttpStatus.OK); }
	 */

}
