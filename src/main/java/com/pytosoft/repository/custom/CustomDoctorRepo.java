package com.pytosoft.repository.custom;

import java.util.List;

import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
import com.pytosoft.vo.ListResponse;



public interface CustomDoctorRepo {

	public List<Doctor> getByName(String doctorName);
	public ListResponse findAllByClinic(Clinic clinic,Doctor doctor);

}
