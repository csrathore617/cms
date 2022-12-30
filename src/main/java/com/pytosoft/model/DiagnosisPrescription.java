package com.pytosoft.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constants.PrescriptionStatus;
import com.pytosoft.constraint.CreateEntity;
import com.pytosoft.util.JsonDateDeserializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnosis_prescription")
//@FetchProfile(name = "diagnosis_prescription_fetch_profile", fetchOverrides = {
//		@FetchProfile.FetchOverride(entity = DiagnosisPrescription.class, association = "visit", mode = FetchMode.JOIN),
//		@FetchProfile.FetchOverride(entity = DiagnosisPrescription.class, association = "prescribedDiagnosis", mode = FetchMode.JOIN),
//		@FetchProfile.FetchOverride(entity = PrescribedDiagnosis.class, association = "diagnosis", mode = FetchMode.JOIN),
//		@FetchProfile.FetchOverride(entity = Visit.class, association = "medicalCase", mode = FetchMode.JOIN) })
public class DiagnosisPrescription implements Serializable
{
	private static final long serialVersionUID = -3718935003577601359L;

	public static final String DOCTOR = "doctor";

	public static final String PRESCRIPTION_DATE = "prescriptionDate";

	public static final String VISIT = "visit";

	public static final String DIAGNOSIS_PRESCRIPTION_FETCH_PROFILE = "diagnosis_prescription_fetch_profile";

	public static final String PRESCCRIBED_DIAGNOSIS = "prescribedDiagnosis";

	public static final String ID = "id";

	public static final String FULL_FILLED = "fullfilled";

	public static final String FULL_FILLED_TRUE = "true";

	public static final String LAST_ACTIVE_ON = "lastActiveOn";

	@NotNull(groups = { CreateEntity.class }, message = "{diagnosisPrescription.id.notNull}")
	@Min(groups = { CreateEntity.class }, value = 1, message = "{diagnosisPrescription.id.min}")
	private Long id;

	private Date prescriptionDate;

//	private Visit visit;

	private List<PrescribedDiagnosis> prescribedDiagnosis;

	private boolean fullfilled;

	private PrescriptionStatus prescriptionStatus;

	private Date lastActiveOn;

	public DiagnosisPrescription()
	{
	}

	public DiagnosisPrescription(Long id)
	{
		super();
		this.id = id;
	}

	@Column(name = "Full_Filled", nullable = false)
	public boolean isFullfilled()
	{
		return fullfilled;
	}

	public void setFullfilled(boolean fullfilled)
	{
		this.fullfilled = fullfilled;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@Column(name = "PrescriptionDate", nullable = false)
	public Date getPrescriptionDate()
	{
		return prescriptionDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "diagnosisPrescription")
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 10)
	public List<PrescribedDiagnosis> getPrescribedDiagnosis()
	{
		return prescribedDiagnosis;
	}

	public void setPrescribedDiagnosis(List<PrescribedDiagnosis> prescribedDiagnosis)
	{
		this.prescribedDiagnosis = prescribedDiagnosis;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setPrescriptionDate(Date prescriptionDate)
	{
		this.prescriptionDate = prescriptionDate;
	}

//	@ManyToOne(optional = false)
//	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id")
//	public Visit getVisit()
//	{
//		return visit;
//	}
//
////	public void setVisit(Visit visit)
//	{
//		this.visit = visit;
//	}

	@Column(name = "Prescription_Status", nullable = false)
	@Enumerated(EnumType.STRING)
	public PrescriptionStatus getPrescriptionStatus()
	{
		return prescriptionStatus;
	}

	public void setPrescriptionStatus(PrescriptionStatus prescriptionStatus)
	{
		this.prescriptionStatus = prescriptionStatus;
	}

	public Date getLastActiveOn()
	{
		return lastActiveOn;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setLastActiveOn(Date lastActiveOn)
	{
		this.lastActiveOn = lastActiveOn;
	}

}
