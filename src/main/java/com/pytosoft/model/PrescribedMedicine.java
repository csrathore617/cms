package com.pytosoft.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.pytosoft.constraint.CreateProcedure;
import com.pytosoft.constraint.CreateVisit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescribed_medicine")
public class PrescribedMedicine implements Serializable
{
	private static final long serialVersionUID = -6071553993970377248L;

	public static final String DRUG = "drug";

	public static final String ORDERING = "ordering";

	private long id;

	@NotNull(message = "{prescribedMedicine.drug.notNull}")
	@Valid
	private Drug drug;

	@NotBlank(groups = { CreateVisit.class ,CreateProcedure.class}, message = "{prescribedMedicine.duration.NotBlank}")
	@Min(groups = { CreateVisit.class ,CreateProcedure.class}, value = 1, message = "{prescribedMedicine.duration.min}")
	@Max(groups = { CreateVisit.class ,CreateProcedure.class}, value = 365, message = "{prescribedMedicine.duration.max}")
	@Pattern(regexp = "[0-9]+", message = "{prescribedMedicine.duration.regex}")
	private String duration;

	@Size(groups = { CreateVisit.class ,CreateProcedure.class}, max = 255, min = 0, message = "{prescribedMedicine.instruction.size}")
	private String instruction;

	@NotBlank(groups = { CreateVisit.class ,CreateProcedure.class}, message = "{prescribedMedicine.frequency.notBlank}")
	@Size(groups = { CreateVisit.class ,CreateProcedure.class}, max = 50, message = "{prescribedMedicine.frequency.size}")
	private String frequency;

//	private MedicinePrescription medicinePrescription;

	private String medicinePrescription;
	
	private String strength;
	
	private String durationType;

	private String notes;
	
	private Integer ordering;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public long getId()
	{
		return id;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "Drug_Id", referencedColumnName = "Id", nullable = true)
	public Drug getDrug()
	{
		return drug;
	}

	@Column(name = "Duration", nullable = false)
	public String getDuration()
	{
		return duration;
	}

	@Column(name = "Instruction", length = 100)
	public String getInstruction()
	{
		return instruction;
	}

	@Column(name = "Frequency", nullable = false)
	public String getFrequency()
	{
		return frequency;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setDrug(Drug drug)
	{
		this.drug = drug;
	}

	public void setDuration(String duration)
	{
		this.duration = duration;
	}

	public void setInstruction(String instruction)
	{
		this.instruction = instruction;
	}

	public void setFrequency(String frequency)
	{
		this.frequency = frequency;
	}

//	@ManyToOne(optional = true)
//	@JoinColumn(name = "Prescription_Id", referencedColumnName = "Id")
	public String getMedicinePrescription()
	{
		return medicinePrescription;
	}

	public void setMedicinePrescription(String medicinePrescription)
	{
		this.medicinePrescription = medicinePrescription;
	}

	@Column(name = "strength", length = 100, nullable = true)
	public String getStrength()
	{
		return strength;
	}

	public void setStrength(String strength)
	{
		this.strength = strength;
	}
	@Column(name = "Duration_Type", nullable = true)
	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	@Column(name = "Notes", length = 1000, nullable = true)
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
