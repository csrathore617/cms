package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.constants.DegreeType;
import com.pytosoft.model.Degree;
import com.pytosoft.repository.DegreeRepository;

@Service
public class DegreeService {

	@Autowired
	private DegreeRepository degreeRepository;

	public List<Degree> getAll() {
		List<Degree> degress = degreeRepository.findAll();
		return degress;
	}

	public void save(List<Degree> listOfDegree) {
//		for(Degree degree : listOfDegree)
//		{
//		degreeRepository.save(degree);
//		}
		degreeRepository.saveAll(listOfDegree);
	}

	public Degree getById(Short id) {
		return degreeRepository.findById(id).get();
	}

	public List<Degree> getByDegreeType(DegreeType degreeType) {
		return degreeRepository.findByDegreeType(degreeType);

	}

//	public void deleteById(Short id)
//	{
//		degreeRepository.deleteById(id);
//	}

}
