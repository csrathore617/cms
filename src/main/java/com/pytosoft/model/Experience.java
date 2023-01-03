package com.pytosoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constants.ExperienceType;
import com.pytosoft.util.JsonDateDeserializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "experience")
public class Experience implements Serializable
{
	private static final long serialVersionUID = 5831609684530712095L;

	private Long id;

	@NotNull(message = "{experience.experienceType.notNull}")
	@Valid
	private ExperienceType experienceType;

	@Past(message = "{experience.fromDate.past}")
	private Date fromDate;

	@Past(message = "{experience.tillDate.past}")
	private Date tillDate;

	@Size(max = 255, message = "{experience.comments.size}")
//	@NotHtml(message = "{experience.notes.notHtml}")
	private String comments;

	@NotBlank(message = "{experience.nameOfInstitue.notBlank}")
	@Size(max = 100, message = "{experience.nameOfInstitue.size}")
//	@AlphaNumeric(message = "{experience.nameOfInstitue.alphaNumeric}")
	private String nameOfInstitue;

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

	@Column(name = "Job_Type", nullable = false)
	@Enumerated(EnumType.STRING)
	public ExperienceType getExperienceType()
	{
		return experienceType;
	}

	public void setExperienceType(ExperienceType experienceType)
	{
		this.experienceType = experienceType;
	}

	@Column(name = "From_Date")
	public Date getFromDate()
	{
		return fromDate;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setFromDate(Date fromDate)
	{
		this.fromDate = fromDate;
	}

	@Column(name = "Till_Date")
	public Date getTillDate()
	{
		return tillDate;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setTillDate(Date tillDate)
	{
		this.tillDate = tillDate;
	}

	@Column(name = "Comments", length = 255)
	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	@Column(name = "NameOfInstitue", length = 100)
	public String getNameOfInstitue()
	{
		return nameOfInstitue;
	}

	public void setNameOfInstitue(String nameOfInstitue)
	{
		this.nameOfInstitue = nameOfInstitue;
	}

}