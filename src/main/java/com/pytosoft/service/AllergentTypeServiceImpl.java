package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.AllergentType;
import com.pytosoft.repository.AllergentTypeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AllergentTypeServiceImpl implements AllergentTypeService {
	@Autowired
	private AllergentTypeRepository allergentTypeRepository;

	@Override
	public List<AllergentType> getAllergentType() {

		return allergentTypeRepository.findAll();
	}

	@Override
	public void save(AllergentType allergentType) {
		allergentTypeRepository.save(allergentType);

	}

	@Override
	public void delete(AllergentType allergentType) {
		allergentTypeRepository.delete(allergentType);

	}

	@Override
	public AllergentType findById(Integer id) {

		return allergentTypeRepository.findById(id).get();
	}

}
