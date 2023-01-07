package com.pytosoft.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.MedicalCase;
import com.pytosoft.model.Patient;
import com.pytosoft.model.Referral;
import com.pytosoft.model.ReferredProcedure;
import com.pytosoft.model.ReferredVisit;
import com.pytosoft.model.Visit;
import com.pytosoft.repository.ReferralRepository;

public class ReferralService {

	@Autowired
	ReferralRepository referralRepository;

	@Autowired
	DoctorService doctorService;

	@Autowired
	PatientService patientService;

	@Autowired
	MedicalCaseService medticalCaseService;
	
	@Autowired
	ProcedureService procedureService;

	@Autowired
	VisitService visitService;

	public Referral saveReferral(Long patientId, Integer medicalCaseId, Referral referral, Long doctorId,
			Long doctorRefToId) {

		Boolean check = this.validate(patientId, medicalCaseId, doctorId, doctorRefToId);
		if (check) {
			Doctor docReferredBy = doctorService.findById(doctorId);
			Doctor docReferredTo = doctorService.findById(doctorRefToId);
			Patient patient = patientService.getPatientById(patientId, null, null);
			MedicalCase medicalCase = medicalCaseRepository.findById(medicalCaseId);

			referral.setReferredBy(docReferredBy);
			referral.setReferredTo(docReferredTo);
			referral.setMedicalCase(medicalCase);
		} else {
			referral = this.saveWithReferral(referral);
		}
		return referralRepository.save(referral);
	}

	private Boolean validate(Long patientId, Integer medicalCaseId, Long doctorId, Long doctorRefToId) {
		Boolean check = (patientId == null) ? check == true : check == false;
		check = (medicalCaseId == null) ? check == true : check == false;
		check = (doctorId == null) ? check == true : check == false;
		check = (doctorRefToId == null) ? check == true : check == false;
		return check;
	}

	private Referral saveWithReferral(Referral referral) {
		Doctor doctorRefBy = doctorService.findById(referral.getReferredBy().getId());
		Patient patien = patientService.getPatientById(referral.getPatient().getId(), null, null);
		Doctor doctorRefTo = doctorService.findById(referral.getReferredTo().getId());
		MedicalCase medicalCase = medicalCaseRepository.findById(referral.getMedicalCase().getId());
		referral = this.saveAllVisit(referral);
		referral = this.saveAllProcedure(referral);

		return referral;
	}

	private Referral saveAllVisit(Referral referral) {
		Set<ReferredVisit> referredVisits = referral.getReferredVisits();
		if (referredVisits != null) {
			for (ReferredVisit rv : referredVisits) {
				rv.setVisit(visitService.findById(rv.getVisit().getId()));
			}
		}
	}
	private Referral saveAllProcedure(Referral referral) {
		Set<ReferredProcedure> referredProcedures = referral.getReferredProcedures();
		if (referredProcedures != null) {
			for (ReferredProcedure rp : referredProcedures) {
				rp.setVisit(procedureService.findById(rp.getProcedure().getId()));
			}
		}
	}

}
