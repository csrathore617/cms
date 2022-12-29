package com.pytosoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "complain_for_specialization")
public class ComplainForSpecialization
{
	public static final String COMPLAIN = "complain";

	public static final String SPECIALIZATION = "specialization";

	private Integer id;

	private Complain complain;

	private Specialization specialization;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Complain_Id", referencedColumnName = "Id")
	public Complain getComplain()
	{
		return complain;
	}

	public void setComplain(Complain complain)
	{
		this.complain = complain;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Specialization_Id", referencedColumnName = "Id")
	public Specialization getSpecialization()
	{
		return specialization;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setSpecialization(Specialization specialization)
	{
		this.specialization = specialization;
	}

}
