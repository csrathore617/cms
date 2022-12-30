package com.pytosoft.model;

import java.sql.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.util.JsonDateDeserializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "immunization_history")
@FetchProfile(name = "fp_ih_immunization", fetchOverrides = { @FetchProfile.FetchOverride(entity = ImmunizationHistory.class, association = "immunization", mode = FetchMode.JOIN) })
public class ImmunizationHistory {
	public static final String FP_IMMUN_HISTORY_IMMUNIZATION = "fp_ih_immunization";

	private Long id;

	@NotNull(message = "{immunizationHistory.immunization.notNull}")
	@Valid
	private Immunization immunization;

	@Past(message = "{immunizationHistory.immunizationDate.past}")
	private Date immunizationDate;

	private Date createdOn;

	private Date nextDue;

	@Size(max = 160, message = "{immunizationHistory.notes.size}")
//	@NotHtml(message = "{immunizationHistory.notes.notHtml}")
	private String notes;

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Immunization_Id", referencedColumnName = "Id")
	public Immunization getImmunization()
	{
		return immunization;
	}

	@Column(name = "Immunization_Date", nullable = true)
	public Date getImmunizationDate()
	{
		return immunizationDate;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setImmunization(Immunization immunization)
	{
		this.immunization = immunization;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setImmunizationDate(Date immunizationDate)
	{
		this.immunizationDate = immunizationDate;
	}

	@Column(name = "Next_Due", nullable = true)
	public Date getNextDue()
	{
		return nextDue;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setNextDue(Date nextDue)
	{
		this.nextDue = nextDue;
	}

	@Column(name = "Notes", nullable = true, length = 255)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

}
