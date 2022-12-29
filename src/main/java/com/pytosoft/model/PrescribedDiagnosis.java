package com.pytosoft.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescribed_diagnosis")
public class PrescribedDiagnosis implements Serializable
{
	private static final long serialVersionUID = 6931783740387415825L;

	private Long id;

//	@NotNull(groups = { UpdateEntity.class, Default.class }, message = "{prescribedDiagnosis.diagnosis.notNull}")
	@Valid
	private Diagnosis diagnosis;

	private DiagnosisPrescription diagnosisPrescription;

//	@NotBlank(groups = { UpdateEntity.class }, message = "{prescribedDiagnosis.result.notBlank}")
//	@Size(groups = { UpdateEntity.class }, max = 50, message = "{prescribedDiagnosis.result.size}")
	private String result;

//	@Size(groups = { UpdateEntity.class }, max = 255, message = "{prescribedDiagnosis.notes.size}")
//	@NotHtml(groups = { UpdateEntity.class }, message = "{prescribedDiagnosis.notes.notHtml}")
	private String notes;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Diagnosis_Id", referencedColumnName = "Id")
	public Diagnosis getDiagnosis()
	{
		return diagnosis;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setDiagnosis(Diagnosis diagnosis)
	{
		this.diagnosis = diagnosis;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "Diagnosis_Prescription_Id", referencedColumnName = "Id")
	public DiagnosisPrescription getDiagnosisPrescription()
	{
		return diagnosisPrescription;
	}

	public void setDiagnosisPrescription(DiagnosisPrescription diagnosisPrescription)
	{
		this.diagnosisPrescription = diagnosisPrescription;
	}

	@Column(name = "Result", nullable = true, length = 50)
	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
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
