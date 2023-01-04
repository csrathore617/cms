package com.pytosoft.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "medical_case")
public class MedicalCase 
{

	
	private Integer id;
	
	private String name;

	
	
	private Patient patient;

	

	private Doctor doctor;

	private Date createdOn;

	private Appointment appointment;

	private Date visitedOn;

	private String comments;

	private String tags;

//	private List<Visit> visits;


	public MedicalCase()
	{

	}

	public MedicalCase(Integer id)
	{
		super();
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Doctor_Id", referencedColumnName = "id")
//	@Exists(message="{doctor.exist}")
	public Doctor getDoctor()
	{
		return doctor;
	}
	public void setDoctor(Doctor doctor)
	{
		this.doctor = doctor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName()
	{
		return name;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "Patent_Id", referencedColumnName = "id")
//	@JsonIgnore
// @Exists(message="{patent.exist}")
	public Patient getPatient()
	{
		return patient;
	}

	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	
//	@OneToMany(mappedBy = "medicalCase", fetch = FetchType.LAZY)
//	public List<Visit> getVisits()
//	{
//		return visits;
//	}
//
//	public void setVisits(List<Visit> visits)
//	{
//		this.visits = visits;
//	}

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	@Column(name = "Comments", nullable = true, length = 255)
	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	@Column(name = "Tags", nullable = true, length = 500)
	public String getTags()
	{
		return tags;
	}

	public void setTags(String tags)
	{
		this.tags = tags;
	}

	@Transient
	public Appointment getAppointment()
	{
		return appointment;
	}

	public void setAppointment(Appointment appointment)
	{
		this.appointment = appointment;
	}

	@Column(name = "visited_On", nullable = false)
	public Date getVisitedOn()
	{
		return visitedOn;
	}

	public void setVisitedOn(Date visitedOn)
	{
		this.visitedOn = visitedOn;
	}

	
}
