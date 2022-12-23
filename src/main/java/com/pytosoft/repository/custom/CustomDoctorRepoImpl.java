package com.pytosoft.repository.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pytosoft.model.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomDoctorRepoImpl implements CustomDoctorRepo {
	
	@Autowired
	EntityManager manager;
	
	public List<Doctor> getByName(String doctorName){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
		Root<Doctor> rootEmp = query.from(Doctor.class);
		
		Predicate namePredicate = builder.equal(rootEmp.get("doctorName"), doctorName);
		query.where(namePredicate); 	
		TypedQuery<Doctor> tQuery = manager.createQuery(query);
		return tQuery.getResultList();
		
		
	}

}