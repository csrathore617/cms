package com.pytosoft.model;


import java.util.Date;
import java.util.List;
import java.util.Set;

import com.pytosoft.model.procedure.CapturedVital;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.model.procedure.PrescribedLabTest;
import com.pytosoft.util.JsonDateDeserializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "visit")
public class Visit 
{

	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Visit_Date", nullable = true)
	private Date date;

	@ManyToOne(/* optional = false, */ fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "Medical_Case_id", referencedColumnName = "Id")
	private MedicalCase medicalCase;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id")
	private Clinic clinic;

	@ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "Appointment_Id", referencedColumnName = "Id")
	private Appointment appointment;

	@Column(name = "Reason_For_Visit", nullable = true, length = 255)
	private String reasonForVisit;

	@Column(name = "Clinical_Note", nullable = true, length = 255)
	private String clinicalNote;

	@Column(name = "examination_Note", nullable = true, length = 5000)
	private String examinationNote;

	private String additionalInstructions;

	private Date createdOn;


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id", nullable = true)
	private Set<PrescribedDiagnosis> prescribedDiagnosises;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY/* , mappedBy = "visit" */)
	@OrderBy(PrescribedLabTest.ORDERING)
	private Set<PrescribedLabTest> prescribedLabTests;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id", nullable = true)
	@OrderBy(PrescribedMedicine.ORDERING)
	private Set<PrescribedMedicine> prescribedMedicines;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id", nullable = true)
	@OrderBy(ObservedComplain.ORDERING)
	private Set<ObservedComplain> observedComplains;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id", nullable = true)
	@OrderBy(DiagnosedDisease.ORDERING)
	private Set<DiagnosedDisease> diagnosedDisease;

	private List<Long> visitAttachment;

//	private Set<TenantVisitMapping> tenantVisitMappings;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "visit")
	private Set<CapturedVital> capturedVitals;
	
	
	
	public Visit()
	{

	}

	public Visit(Long id)
	{
		super();
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	
	public Long getId()
	{
		return id;
	}


	public MedicalCase getMedicalCase()
	{
		return medicalCase;
	}
	public void setMedicalCase(MedicalCase medicalCase)
	{
		this.medicalCase = medicalCase;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setId(Long id)
	{
		this.id = id;
	}


	
	public Clinic getClinic()
	{
		return clinic;
	}

	public void setClinic(Clinic clinic)
	{
		this.clinic = clinic;
	}

	public String getReasonForVisit()
	{
		return reasonForVisit;
	}

	public String getClinicalNote()
	{
		return clinicalNote;
	}

	public void setClinicalNote(String clinicalNote)
	{
		this.clinicalNote = clinicalNote;
	}

	public void setReasonForVisit(String reasonForVisit)
	{
		this.reasonForVisit = reasonForVisit;
	}

	
	public Set<PrescribedDiagnosis> getPrescribedDiagnosises()
	{
		return prescribedDiagnosises;
	}

	public void setPrescribedDiagnosises(Set<PrescribedDiagnosis> prescribedDiagnosises)
	{
		this.prescribedDiagnosises = prescribedDiagnosises;
	}


	public Set<PrescribedMedicine> getPrescribedMedicines()
	{
		return prescribedMedicines;
	}

	public void setPrescribedMedicines(Set<PrescribedMedicine> prescribedMedicines)
	{
		this.prescribedMedicines = prescribedMedicines;
	}

	
	public Set<ObservedComplain> getObservedComplains()
	{
		return observedComplains;
	}

	public void setObservedComplains(Set<ObservedComplain> observedComplains)
	{
		this.observedComplains = observedComplains;
	}

	
	public Set<DiagnosedDisease> getDiagnosedDisease()
	{
		return diagnosedDisease;
	}

	public void setDiagnosedDisease(Set<DiagnosedDisease> diagnosedDisease)
	{
		this.diagnosedDisease = diagnosedDisease;
	}

	
	public Appointment getAppointment()
	{
		return appointment;
	}

	public void setAppointment(Appointment appointment)
	{
		this.appointment = appointment;
	}

	public String getExaminationNote()
	{
		return examinationNote;
	}

	public void setExaminationNote(String examinationNote)
	{
		this.examinationNote = examinationNote;
	}

	@Column(name = "additional_instructions", nullable = true, length = 1000)
	public String getAdditionalInstructions()
	{
		return additionalInstructions;
	}

	public void setAdditionalInstructions(String additionalInstructions)
	{
		this.additionalInstructions = additionalInstructions;
	}

	/*
	 * public Set<CapturedVital> getCapturedVitals() { return capturedVitals; }
	 * 
	 * public void setCapturedVitals(Set<CapturedVital> capturedVitals) {
	 * this.capturedVitals = capturedVitals; }
	 *  for ui only
	 */
	@Transient
	public List<Long> getVisitAttachment()
	{
		return visitAttachment;
	}

	public void setVisitAttachment(List<Long> visitAttachment)
	{
		this.visitAttachment = visitAttachment;
	}

	@Column(name = "Created_On", nullable = true)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}


	public Set<PrescribedLabTest> getPrescribedLabTests()
	{
		return prescribedLabTests;
	}

	public void setPrescribedLabTests(Set<PrescribedLabTest> prescribedLabTests)
	{
		this.prescribedLabTests = prescribedLabTests;
	}

}
