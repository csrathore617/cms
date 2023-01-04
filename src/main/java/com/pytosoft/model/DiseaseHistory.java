package com.pytosoft.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
@Table(name = "disease_history")
@FetchProfile(name = "fp_dh_diseases", fetchOverrides = { @FetchProfile.FetchOverride(entity = DiseaseHistory.class, association = "disease", mode = FetchMode.JOIN) })
public class DiseaseHistory
{

	public static final String FP_DISEASE_HISTORY_DISEASE = "fp_dh_diseases";

	private Long id;

	@NotNull(message = "{diseaseHistory.disease.notNull}")
	@Valid
	private Disease disease;

	private Date createdOn;

	private boolean past;

	private Date since;

	@Size(max = 160, message = "{diseaseHistory.notes.size}")
	//@NotHtml(message = "{diseaseHistory.notes.notHtml}")
	private String notes;

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Disease_Id", referencedColumnName = "Id")
	public Disease getDisease()
	{
		return disease;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public void setDisease(Disease disease)
	{
		this.disease = disease;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "Past")
	public boolean isPast()
	{
		return past;
	}

	public void setPast(boolean past)
	{
		this.past = past;
	}

	@Column(name = "Since", nullable = true)
	public Date getSince()
	{
		return since;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setSince(Date since)
	{
		this.since = since;
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

