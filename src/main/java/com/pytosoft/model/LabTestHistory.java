package com.pytosoft.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constraint.NotHtml;
import com.pytosoft.util.JsonDateDeserializer;

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
@Table(name = "lab_test_history")
public class LabTestHistory
{

	public static final String LAB_TEST = "labTest";

	private Long id;

	@NotNull(message = "{labTestHistory.labTest.notNull}")
	@Valid
	private Diagnosis labTest;

	private Date testedOn;

	//@NotBlank(message = "{labTestHistory.result.notBlank}")
	@Size(max = 100, message = "{labTestHistory.result.size}")
	@NotHtml(message = "{labTestHistory.result.notHtml}")
	private String result;

	@Size(max = 100, message = "{labTestHistory.actions.size}")
	@NotHtml(message = "{labTestHistory.actions.notHtml}")
	private String actions;

	@Size(max = 160, message = "{labTestHistory.notes.size}")
	@NotHtml(message = "{labTestHistory.notes.notHtml}")
	private String notes;

	private Date createdOn;

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Lab_Test_Id", referencedColumnName = "Id", nullable = false)
	public Diagnosis getLabTest()
	{
		return labTest;
	}

	public void setLabTest(Diagnosis labTest)
	{
		this.labTest = labTest;
	}

	@Column(name = "Tested_On", nullable = true)
	public Date getTestedOn()
	{
		return testedOn;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setTestedOn(Date testedOn)
	{
		this.testedOn = testedOn;
	}

	@Column(name = "Result", nullable = true, length = 100)
	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	@Column(name = "Actions", nullable = true, length = 100)
	public String getActions()
	{
		return actions;
	}

	public void setActions(String actions)
	{
		this.actions = actions;
	}

	@Column(name = "Notes", nullable = true, length = 100)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

}
