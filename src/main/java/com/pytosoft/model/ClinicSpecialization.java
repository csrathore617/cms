package com.pytosoft.model;

import javax.validation.Valid;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinic_specialization")
public class ClinicSpecialization
{
	public static final String SPECIALIZATION ="specialization";
	private Long id;

	
	private Specialization specialization;

	public ClinicSpecialization()
	{

	}

//	public ClinicSpecialization(Clinic clinic, Specialization specialization)
//	{
//		super();
//		this.clinic = clinic;
//		this.specialization = specialization;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

//	@ManyToOne(optional = false)
//	// @JsonIgnore
//	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id")
//	public Clinic getClinic()
//	{
//		return clinic;
//	}
//
//	public void setClinic(Clinic clinic)
//	{
//		this.clinic = clinic;
//	}

	@ManyToOne(optional = true,cascade = CascadeType.ALL)
	@JoinColumn(name = "Specialization_Id", referencedColumnName = "Id")
	public Specialization getSpecialization()
	{
		return specialization;
	}

	public void setSpecialization(Specialization specialization)
	{
		this.specialization = specialization;
	}

}
