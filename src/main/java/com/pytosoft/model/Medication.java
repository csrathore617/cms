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
@Table(name = "medication")
@FetchProfile(name = "fp_medication_drug", fetchOverrides = { @FetchProfile.FetchOverride(entity = Medication.class, association = "drug", mode = FetchMode.JOIN) })
public class Medication
{
	public static final String FP_MEDICATION_DRUG = "fp_medication_drug";

	private Long id;

	private Byte beingTakenForDays;

	@NotNull(message = "{medication.drug.notNull}")
	@Valid
	private Drug drug;

	private Date createdOn;

	// new fields added
	//@NotBlank(message = "{medication.medicineType.notBlank}")
	@Size(max = 100, message = "{medication.medicineType.size}")
	//@NotHtml(message = "{medication.medicineType.notHtml}")
	private String medicineType;

	@Size(max = 100, message = "{medication.dosage.size}")
	private String dosage;

	private Date startDate;

	private Date endDate;

	@Size(max = 160, message = "{medication.instructions.size}")
	//@NotHtml(message = "{medication.instructions.notHtml}")
	private String instructions;

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

	public void setId(Long id)
	{
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Drug_Id", referencedColumnName = "Id")
	public Drug getDrug()
	{
		return drug;
	}

	public void setDrug(Drug drug)
	{
		this.drug = drug;
	}

	@Column(name = "Being_Taken_For_Days")
	public Byte getBeingTakenForDays()
	{
		return beingTakenForDays;
	}

	public void setBeingTakenForDays(Byte beingTakenForDays)
	{
		this.beingTakenForDays = beingTakenForDays;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	// added for new fields
	@Column(name = "Dosage", nullable = true, length = 50)
	public String getDosage()
	{
		return dosage;
	}

	public void setDosage(String dosage)
	{
		this.dosage = dosage;
	}

	@Column(name = "Start_Date", nullable = true)
	public Date getStartDate()
	{
		return startDate;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	@Column(name = "End_Date", nullable = true)
	public Date getEndDate()
	{
		return endDate;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	@Column(name = "Instructions", nullable = true, length = 255)
	public String getInstructions()
	{
		return instructions;
	}

	public void setInstructions(String instructions)
	{
		this.instructions = instructions;
	}

	@Column(name = "Medicine_Type", nullable = true, length = 100)
	public String getMedicineType()
	{
		return medicineType;
	}

	public void setMedicineType(String medicineType)
	{
		this.medicineType = medicineType;
	}

}
