package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.constants.DegreeType;
import com.pytosoft.model.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Short>{

	public List<Degree> findByDegreeType(DegreeType degreeType);
	
}
