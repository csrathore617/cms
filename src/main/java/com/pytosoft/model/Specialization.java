package com.pytosoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Specialization {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	private String nameOfDegree;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameOfDegree() {
		return nameOfDegree;
	}

	public void setNameOfDegree(String nameOfDegree) {
		this.nameOfDegree = nameOfDegree;
	}

	
}
