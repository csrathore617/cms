package com.pytosoft.model;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

import com.pytosoft.constraint.CreateEntity;

import jakarta.persistence.CascadeType;
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
@Table(name = "medicine")
public class Medicine {

	public static final String FP_MEDICINE_DRUG = "fp_medicine_drug";

	public static final String DRUG = "drug";

	public static final String ID = "id";

	public static final String FAVORITE_MEDICINE = "favoriteMedicine";

	@NotNull(message = "{medicine.id.notNull}")

	@Min(value = 1, message = "{medicine.id.min}")

	private Long id;

	@NotNull(groups = { CreateEntity.class }, message = "{medicine.drug.notNull}")

	@Valid()
	private Drug drug;

	@NotBlank(groups = { CreateEntity.class }, message = "{medicine.instruction.notBlank}")

	@Size(max = 255, min = 10, message = "{medicine.instruction.size}")

	private String instruction;

	@NotBlank(groups = { CreateEntity.class }, message = "{medicine.frequency.notBlank}")

	@Size(max = 50, message = "{medicine.frequency.size}")

	private String frequency;

	@Min(groups = { CreateEntity.class }, value = 1, message = "{medicine.duration.min}")

	@Max(groups = { CreateEntity.class }, value = 365, message = "{medicine.duration.max}")

	private short duration;

	private String strength;

	private String durationType;

	@Value("true")
	private boolean isActive;

	private FavoriteMedicine favoriteMedicine;

	private Doctor doctor;

	public Medicine() {

	}

	public Medicine(Long id) {
		super();
		this.id = id;
	}

	public Medicine(Long id, Drug drug, short duration) {
		super();
		this.id = id;
		this.drug = drug;
		this.duration = duration;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * @Fetch(FetchMode.SELECT)
	 * 
	 * @BatchSize(size = 10)
	 */
	// @NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Drug_Id", referencedColumnName = "Id", nullable = true)
	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	@Column(name = "Duration")
	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	@Column(name = "Instruction", nullable = true)
	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Column(name = "Frequency", nullable = true)
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Column(name = "strength", length = 100, nullable = true)
	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	@Column(name = "duration_type", nullable = true)
	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "favorite_medicine_Id", referencedColumnName = "Id")
	public FavoriteMedicine getFavoriteMedicine() {
		return favoriteMedicine;
	}

	public void setFavoriteMedicine(FavoriteMedicine favoriteMedicine) {
		this.favoriteMedicine = favoriteMedicine;
	}

	/**
	 * @return the doctor
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "doc_id", referencedColumnName = "id")
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
