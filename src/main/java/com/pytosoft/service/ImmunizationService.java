package com.pytosoft.service;

import java.util.List;

import com.pytosoft.model.Immunization;
import com.pytosoft.vo.ListResponse;

public interface ImmunizationService {

	public List<Immunization> getImmunization();

	public void save(Immunization immunization);

	public Immunization findById(Short id);

	public void delete(Immunization immunization);
	
	public ListResponse findByName(String name);

}
