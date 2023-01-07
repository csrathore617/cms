package com.pytosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.Referral;
import com.pytosoft.service.ReferralService;
import com.pytosoft.vo.ListResponse;
import com.pytosoft.vo.ReferralVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/referrals")
public class ReferralController {

	@Autowired
	private ReferralService referralService;

	@PostMapping("/save/patient/{patientId}/medicalc/{medicalCaseId}/doctorfrom/{doctorId}/doctorto/{doctorRefToId}")
	@ResponseBody
	public ResponseEntity<Referral> create(@RequestBody Referral referral,@PathVariable("{patientId}")Long patientId,
			@PathVariable("{medicalCaseId}") Integer medicalCaseId,@PathVariable("{doctorId}") Long doctorId , 
			@PathVariable("{doctorRefToId}") Long doctorRefToId, HttpServletRequest request)
	{
		
			Referral saved = referralService.saveReferral(patientId, medicalCaseId, referral, doctorId, doctorRefToId);
		
			/*
			 * Doctor doctor = getLoggedInDoctor(request); Referral saved; if
			 * (referral.getMedicalCase() != null) { saved =
			 * referralService.saveCaseReferral(referral, doctor); } else { saved =
			 * referralService.savePatientReferral(referral, doctor); }
			 */
		return new ResponseEntity<Referral>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	@ResponseBody
	public ResponseEntity<ListResponse> getAll(HttpServletRequest request,
			@RequestParam(required = false) boolean caseRequired, @RequestParam ReferralType referralType) {
//		Doctor doctor = getLoggedInDoctor(request);
//		SearchCriteria searchCriteria = WebUtils.getSearchCriteria(request);
		ListResponse result = null;
		if (caseRequired) {
			result = referralService.findCaseReferrals(doctor, searchCriteria, caseRequired, referralType);
		} else {
			result = referralService.findPatientReferrals(doctor, searchCriteria, caseRequired, referralType);
		}

		result.setsEcho(S_ECHO);
		return new ResponseEntity<ListResponse>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ReferralVO> get(@PathVariable Long id, HttpServletRequest request) {
//		Doctor doctor = getLoggedInDoctor(request);
//		ReferralVO referralVO = referralService.getReferralById(id, doctor);
		return new ResponseEntity<ReferralVO>(referralVO, HttpStatus.OK);
	}

	@GetMapping("/medicalcases/{id}")
	@ResponseBody
	public ResponseEntity<ReferralVO> getCaseReferral(@PathVariable Long id, HttpServletRequest request) {
//		Doctor doctor = getLoggedInDoctor(request);
//		ReferralVO referralVO = referralService.getCaseReferralById(id, doctor);
		return new ResponseEntity<ReferralVO>(referralVO, HttpStatus.OK);
	}

}
