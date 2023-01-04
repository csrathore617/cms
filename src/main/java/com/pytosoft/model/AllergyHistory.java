package com.pytosoft.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.FetchMode;

import org.hibernate.annotations.FetchProfile;

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
@Table(name = "allergy_history")
public class AllergyHistory
{
	public static final String FP_ALLERGY_HISTORY_ALLERGY = "fp_ah_allergies";

	private Long id;

	@Past(message = "{allergyHistory.discoveredOn.past}")
	private Date discoveredOn;

	@Valid
	private AllergentType allergentType;

	@Valid
	private AllergyType allergyType;

	@Size(max = 100, message = "{allergyHistory.allergent.size}")
	//@AlphaNumeric(message = "{allergyHistory.allergent.alphaNumeric}")
	private String allergent;

	@Valid
	private AllergyReaction allergyReaction;

	private Date createdOn;

	@Size(max = 160, message = "{allergyHistory.notes.size}")
	//@NotHtml(message = "{allergyHistory.notes.notHtml}")
	private String notes;

	@ManyToOne(optional = true)
	@JoinColumn(name = "allergentType_Id", referencedColumnName = "Id")
	public AllergentType getAllergentType()
	{
		return allergentType;
	}

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setAllergentType(AllergentType allergentType)
	{
		this.allergentType = allergentType;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public void setId(Long id)
	{
		this.id = id;
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

	@Column(name = "Discovered_On", nullable = true)
	public Date getDiscoveredOn()
	{
		return discoveredOn;
	}

	@com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = JsonDateDeserializer.class)
	public void setDiscoveredOn(Date discoveredOn)
	{
		this.discoveredOn = discoveredOn;
	}

	@Column(name = "allergent", nullable = true, length = 255)
	public String getAllergent()
	{
		return allergent;
	}

	public void setAllergent(String allergent)
	{
		this.allergent = allergent;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "allergyType_Id", referencedColumnName = "Id")
	public AllergyType getAllergyType()
	{
		return allergyType;
	}

	public void setAllergyType(AllergyType allergyType)
	{
		this.allergyType = allergyType;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "allergyReaction_Id", referencedColumnName = "Id")
	public AllergyReaction getAllergyReaction()
	{
		return allergyReaction;
	}

	public void setAllergyReaction(AllergyReaction allergyReaction)
	{
		this.allergyReaction = allergyReaction;
	}

}