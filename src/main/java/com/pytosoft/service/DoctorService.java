package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.DegreePassed;
import com.pytosoft.model.Doctor;
import com.pytosoft.repository.ClinicRepository;
import com.pytosoft.repository.DoctorRepository;
import com.pytosoft.vo.ListResponse;

@Service
public class DoctorService {
	@Autowired
	DoctorRepository repo;
	
	@Autowired
	ClinicRepository clinicRepo;

	/*
	 * public List<Doctor> findAll() { return repo.findAll(); }
	 */
	public ListResponse findAll(/* SearchCriteria searchCriteria, */ /* Clinic clinic */)
	{
		
//		if (clinic != null)
//		{
//			response = doctorDAO.findAllByClinic(searchCriteria, clinic);
//		} else
//		{
//			response = doctorDAO.findAll(searchCriteria);
//		}
		
		List<Doctor> doctors = (List<Doctor>) repo.findAll();
//		List<DoctorVO> doctorVOs = DAOUtils.toDoctorVos(doctors);
		ListResponse response =new ListResponse(doctors.size(),doctors.size(),doctors);

		return response;
	}
	
	public Doctor save(Doctor entity) {

		return repo.save(entity);

	}

	public Doctor saveOrUpdate(Doctor entity) {

		repo.findById(entity.getId());
		Doctor docUpdate = new Doctor(entity.getId(), entity.getDoctorName(), entity.getDoctorSpecializations(),
				entity.getDegreesPassed(), entity.isAcceptsNewPatient());
		return repo.save(docUpdate);

	}

	public Doctor getEntity(Doctor entity) {
		return repo.findById(entity.getId()).orElse(new Doctor("NoSuchDoctor"));

	}

	public void delete(Long docId,String docName) {
		
		if (docId != null/* && !docId.equals(0L) */) {
			repo.deleteById(docId);
			System.out.println("deleted by id");
		}
		else if(docName!=null&&!docName.isEmpty()) {
			Doctor doc =findByName(docName).get(0);
				repo.deleteById(doc.getId());
				System.out.println("deleted by Name");
		}
		
//		repo.delete(entity);

	}

	public List<Doctor> findByName(String Name) {
		return repo.getByName(Name);
	}

	public Doctor findById(Long id) {
		return repo.findById(id).get();
	}

	public void deleteById(Long id) {
		repo.deleteById(id);

	}

	public Long getCoundByName(String doctorName) {
		return repo.countByDoctorName(doctorName).orElse(0l);

	}

	public Boolean exists(String doctorName) {
		return repo.existsByDoctorName(doctorName);
	}

	public Long getCount() {
		return repo.count();
	}
	public ListResponse findAllByClinic(Long docId, Long clincId) {
		
		Doctor doc =repo.findById(docId).get();
		Clinic clinc =clinicRepo.findById( Integer.valueOf(clincId.intValue())).get();
		return repo.findAllByClinic(clinc, doc);
		
	}
	public void deleteDegreePassed(Long id,Long doctor_id) {
//		DegreePassed dPassed = repo.findByDegreePassedId(id);
		if (id ==null) {
			Doctor doctor =repo.findById(doctor_id).get();
			id = doctor.getDegreesPassed().iterator().next().getId();
		}
		repo.deleteDegreePassedById(id);
	}

	public void deleteExpertise(Long id,Long doctor_id) {

		if (id ==null) {
			Doctor doctor =repo.findById(doctor_id).get();
			id = doctor.getDegreesPassed().iterator().next().getId();
		}
		repo.deleteExpertise(id);
	}
	

	
	
	

}
