package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.GiqliParamValue;
import com.pytosoft.repository.GiqliParamValueRepository;

@Service
public class GiqliParamValueService {

	@Autowired
	GiqliParamValueRepository giqliParamValuerepository;

	public GiqliParamValue saveGiqli(GiqliParamValue giqliParamValue) {
		return giqliParamValuerepository.save(giqliParamValue);
	}

	public List<GiqliParamValue> getAllGiqliParamValue() {
		return giqliParamValuerepository.findAll();
	}

	public GiqliParamValue getGiqliParamValueById(Long id) {
		return giqliParamValuerepository.findById(id).get();
	}

	public void delete(Long id) {
		
		giqliParamValuerepository.deleteById(id);
	}

}
