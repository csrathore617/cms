package com.pytosoft.model;


import javax.validation.constraints.Min;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "complain")
public class Complain 
{

	public static final String NAME = "name";

	public static final String ID = "id";

	@Min(value = 1, message = "{complain.id.min}")
	private Integer id;

	
	private String name;
	
	
	private Doctor doctor;

	public Complain()
	{

	}

	public Complain(Integer id)
	{
		super();
		this.id = id;
	}

	public Complain(final Integer id, final String name)
	{
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	@Column(name = "Name", nullable = false, length = 255)
	public String getName()
	{
		return name;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the doctor
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "doc_id", referencedColumnName = "doc_id")
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	

}
