package com.pytosoft.repository.custom;

import java.util.List;

import com.pytosoft.model.Doctor;



public interface CustomDoctorRepo {

	public List<Doctor> getByName(String doctorName);

}
