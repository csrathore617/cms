package com.pytosoft.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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
@Table(name = "family_history")
public class FamilyHistory
{
	private Long id;

	@NotNull(message = "{familyHistory.disease.notNull}")
	@Valid
	private Disease disease;

	@NotBlank(message = "{familyHistory.relationship.notBlank}")
	//@AlphaNumeric(message = "{familyHistory.relationship.alphaNumeric}")
	@Size(max = 100, message = "{familyHistory.relationship.size}")
	private String relationship;

	@Past(message = "{familyHistory.since.past}")
	private Date since;

	@Size(max = 100, message = "{familyHistory.currentStatus.size}")
	//@AlphaNumeric(message = "{familyHistory.currentStatus.alphaNumeric}")
	private String currentStatus;

	@Size(max = 160, message = "{familyHistory.notes.size}")
	//@NotHtml(message = "{familyHistory.notes.notHtml}")
	private String notes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "Relationship", nullable = true)
	public String getRelationship()
	{
		return relationship;
	}

	public void setRelationship(String relationship)
	{
		this.relationship = relationship;
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

	@Column(name = "Current_Status", nullable = true)
	public String getCurrentStatus()
	{
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus)
	{
		this.currentStatus = currentStatus;
	}

	@Column(name = "Notes", nullable = true)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Disease_Id", referencedColumnName = "Id", nullable = false)
	public Disease getDisease()
	{
		return disease;
	}

	public void setDisease(Disease disease)
	{
		this.disease = disease;
	}

}

