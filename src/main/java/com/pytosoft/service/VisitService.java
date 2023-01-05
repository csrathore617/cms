package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.MedicalCase;
import com.pytosoft.model.Patient;
import com.pytosoft.model.ReferredVisit;
import com.pytosoft.model.Visit;
import com.pytosoft.model.scheduling.DoctorClinicAssignment;
import com.pytosoft.repository.DoctorRepository;
import com.pytosoft.repository.VisitRepository;
import com.pytosoft.vo.VisitVO;

@Service
public class VisitService {

	@Autowired
	private VisitRepository repo;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private DoctorClinicAssignmentService doctorClinicAssignmentService;
	
	
	public List<Visit> findAll() {
		return repo.findAll();
	}

	public Visit save(Visit entity,Long doctorID,Integer clinicID,Long patientId,Long doctorClinicAssignmentId) {
		Doctor doctor = doctorService.findById(doctorID);
		Patient patient = patientService.getPatientById(patientId, null, null);
		Clinic clinic = clinicService.findById(clinicID);
		DoctorClinicAssignment clinicAssignment = doctorClinicAssignmentService.findById(doctorClinicAssignmentId);
		
		entity.setClinic(clinic);
		
		entity.getMedicalCase().setDoctor(doctor);
		entity.getMedicalCase().setPatient(patient);
		entity.getAppointment().setPatient(patient);
		entity.getAppointment().getBillableService().setCreatedBy(doctor);
		entity.getAppointment().getLabOrder().setPatient(patient);
		entity.getAppointment().setDoctorClinicAssignment(clinicAssignment);
		entity.getMedicalCase().setAppointment(entity.getAppointment());
		return repo.save(entity);

	}
	public ReferredVisit getReferredVisit(Long doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).get();
		MedicalCase medicalCase = repo.findByMedicalCaseDoctorID(doctorId).get(0);
		Visit visit = repo.findByMedicalCase(medicalCase).get();
		ReferredVisit referredVisit = repo.findByVisitId(visit).get();
	
		return referredVisit;
	}

	/*
	 * public Visit saveOrUpdate(Visit entity) {
	 * 
	 * repo.findById(entity.getId()); Visit visitUpdate = new Visit(entity.getId(),
	 * entity.getVisitName(), entity.getVisitSpecializations(),
	 * entity.getDegreesPassed(), entity.isAcceptsNewPatient()); return
	 * repo.save(docUpdate);
	 * 
	 * }
	 */
	public Visit getEntity(Visit entity) {
		return repo.findById(entity.getId()).orElse(null);

	}

	public void delete(Visit entity) {
		repo.delete(entity);

	}

	/*
	 * public List<Visit> findByName(String Name) { return repo.getByName(Name); }
	 */

	public Visit findById(Long id) {
		return repo.findById(id).get();
	}

	public void deleteById(Long id) {
		repo.deleteById(id);

	}

	/*
	 * public Long getCoundByName(String VisitName) { return
	 * repo.countByVisitName(VisitName).orElse(0l);
	 * 
	 * }
	 */

	public Boolean exists(Long VisitId) {
		return repo.existsById(VisitId);
	}

	public Long getCount() {
		return repo.count();
	}
//	public Visit findByPatient(Long id) {
//		return repo.findByPatient(id);
//	}
	
//	public Visit findByDoctor(Doctor doctor) {
//		return repo.findByDoctor(doctor);
//	}
//	
//	public Visit findByPatient(Patient patient) {
//		return repo.findByPatient(patient);
//	}
	



	
}
