package com.pytosoft.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;
import com.pytosoft.model.scheduling.DoctorClinicAssignment;
import com.pytosoft.repository.ClinicRepository;
import com.pytosoft.repository.DoctorRepository;
import com.pytosoft.repository.PatientRepository;

@Service
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	public List<Clinic> getAllClinic() {
		return clinicRepository.findAll();
	}

	public Clinic findById(Integer id) {
		return clinicRepository.findById(id).get();
	}

	public List<Clinic> findAllByDoctor(Long doctorId) {
//		List<Clinic> listOfClinic = null;
//		ArrayList<Integer> listOfClinicId = new ArrayList<>();
//		ResultSet result = clinicRepository.findById(doctorId);
//		try {
//			while(result.next()) {
//			
//				listOfClinicId.add(result.getInt("clinic_id"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	  for (int i = 0; i < listOfClinicId.size(); i++) {
//		  Clinic clinic = clinicRepository.findById(listOfClinicId.get(i)).get();
//		  listOfClinic.add(clinic);
//	}
		//ResultSet resultSet = clinicRepository.findById(doctorId);
		List<Clinic> listOfClinic = clinicRepository.findById(doctorId);
		
		
			return listOfClinic;
		
	}


//	public List<Clinic> findAllByPatient(Long PatientId) {
//		Patient patient = patientRepository.findById(PatientId).get();
//		return clinicRepository.findByPatient(patient);
//	}
//
//	public List<Clinic> findAllByDoctorAndPatient(Long doctorId, Long PatientId) {
//		Doctor doctor = doctorRepository.findById(doctorId).get();
//		Patient patient = patientRepository.findById(PatientId).get();
//
//		return clinicRepository.findByDoctorAndPatient(doctor, patient);
//	}

	public void saveClinic(Clinic clinic, Long doctorId, Long patientId) {
//		Doctor doctor =    doctorRepository.findById(doctorId).get();
//		Patient patient =  patientRepository.findById(patientId).get();
//
//		clinic.setDoctor(doctor);
//		clinic.setPatient(patient);

		clinicRepository.save(clinic);
	}

	public void deleteClinic(Integer id) {
		Clinic clinic = clinicRepository.findById(id).get();
		clinic.setActive(false);

		clinicRepository.save(clinic);
	}

}
