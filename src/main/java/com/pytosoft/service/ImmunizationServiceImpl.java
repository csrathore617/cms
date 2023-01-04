package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Immunization;
import com.pytosoft.repository.ImmunizationRepository;
import com.pytosoft.vo.ListResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImmunizationServiceImpl implements ImmunizationService {

	@Autowired
	private ImmunizationRepository immunizationRepository;

	@Override
	public List<Immunization> getImmunization() {

		return immunizationRepository.findAll();
	}

	@Override
	public void save(Immunization immunization) {
		immunizationRepository.save(immunization);

	}

	@Override
	public Immunization findById(Short id) {

		return immunizationRepository.findById(id).get();
	}

	@Override
	public void delete(Immunization immunization) {
		immunizationRepository.delete(immunization);

	}

	@Override
	public ListResponse findByName(String name) {
		List<Immunization> result = immunizationRepository.findByName(name);
		return new ListResponse(result.size(),result.size(),result);
	}

}
