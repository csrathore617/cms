package com.pytosoft.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnosed_disease")
public class DiagnosedDisease implements Serializable
{

	private static final long serialVersionUID = 594133384209491528L;
	
	public static final String DISEASE ="disease";

	public static final String ORDERING = "ordering";

	private Long id;

	@NotNull(message = "{diagnosedDisease.complain.notNull}")
	@Valid
	private Disease disease;

//	@NotHtml(message = "{diagnosedDisease.notes.notHtml}")
	private String notes;
	
	private Integer ordering;

	@ManyToOne(optional = false)
	@JoinColumn(name = "Disease_Id", referencedColumnName = "Id")
	public Disease getDisease()
	{
		return disease;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setDisease(Disease disease)
	{
		this.disease = disease;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "Notes", length = 255, nullable = true)
	@Size(max = 255, message = "{diagnosedDisease.notes.size}")
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	@Column(name = "Ordering", nullable = true)
	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
}
