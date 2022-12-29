package com.pytosoft.model;

import com.pytosoft.constants.DegreeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity@Table(name = "degree")
public class Degree {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@Column(name = "degree_name")
	private String name;
	@Column(name = "short_name")
	private String shortName;

	// for ui only
	@Column(name = "other_degree_name")
	private String otherDegreeName;
	
	private DegreeType degreeType;


	public Short getId() {
		return id;
	}

	public DegreeType getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(DegreeType degreeType) {
		this.degreeType = degreeType;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getOtherDegreeName() {
		return otherDegreeName;
	}

	public void setOtherDegreeName(String otherDegreeName) {
		this.otherDegreeName = otherDegreeName;
	}
	

}