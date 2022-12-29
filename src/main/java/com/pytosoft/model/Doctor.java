package com.pytosoft.model;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Doctors")
public class Doctor {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String doctorName;


	@OneToMany( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name ="Doctor_id",referencedColumnName ="id" )
	private Set<DoctorSpecialization> doctorSpecializations;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name ="Doctor_id",referencedColumnName ="id" )
	private Set<DegreePassed> degreesPassed;

//	private Set<Expertise> expertises;

//	private Set<Experience> experiences;

	private boolean acceptsNewPatient;

//	private boolean availableForHomeVisit;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Set<DoctorSpecialization> getDoctorSpecializations() {
		return doctorSpecializations;
	}

	public void setDoctorSpecializations(Set<DoctorSpecialization> doctorSpecializations) {
		this.doctorSpecializations = doctorSpecializations;
	}

	public Set<DegreePassed> getDegreesPassed() {
		return degreesPassed;
	}

	public void setDegreesPassed(Set<DegreePassed> degreesPassed) {
		this.degreesPassed = degreesPassed;
	}

	public boolean isAcceptsNewPatient() {
		return acceptsNewPatient;
	}

	public void setAcceptsNewPatient(boolean acceptsNewPatient) {
		this.acceptsNewPatient = acceptsNewPatient;
	}

	public Doctor(Long id, String doctorName, Set<DoctorSpecialization> doctorSpecializations,
			Set<DegreePassed> degreesPassed, boolean acceptsNewPatient) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.doctorSpecializations = doctorSpecializations;
		this.degreesPassed = degreesPassed;
		this.acceptsNewPatient = acceptsNewPatient;
	}

	public Doctor(String doctorName) {
		super();
		this.doctorName = doctorName;
	}
	
	
}
