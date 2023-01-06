package com.pytosoft.model;

import jakarta.persistence.*;

@Entity
@Table(name ="hospital_specialization")
public class HospitalSpecialization {

	public static final String SPECIALIZATION ="specialization";
	private Long id;

	
	private Specialization specialization;


	public HospitalSpecialization() {
		
	}
	
	
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
	
	@ManyToOne(optional = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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
