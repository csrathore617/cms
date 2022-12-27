package com.pytosoft.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
@Table(name = "available_facility")
public class AvailableFacility
{

	public static  final String FACILITY ="facility";
	private Long id;

	//@NotNull(message = "{availableFacility.facility.notNull}")
	@Valid
	private Facility facility;

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

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "Facility_Id", referencedColumnName = "Id")
	public Facility getFacility()
	{
		return facility;
	}

	public void setFacility(Facility facility)
	{
		this.facility = facility;
	}

}
