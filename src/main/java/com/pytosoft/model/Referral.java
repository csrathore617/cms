package com.pytosoft.model;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "referral")
public class Referral 
{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -1439206752109682859L;

	public static final String REFERRED_TO = "referredTo";

	public static final String REFERRED_BY = "referredBy";

	public static final String MEDICAL_CASE = "medicalCase";

	public static final String PATIENT = "patient";

	public static final String PATIENT_FIRST_NAME = "patient.firstName";

	public static final String PATIENT_LAST_NAME = "patient.lastName";

	public static final String PATIENT_MOBILE = "patient.mobile";

	public static final String CASE_NAME = "medicalCase.name";

	public static final String REFERRED_DATE = "referredOn";

	public static final String ADD_TO_MY_PATIENT = "addToMyPatient";

	private Long id;

	@Valid
	private Doctor referredBy;

	@NotNull(message = "{referral.doctor.notNull}")
	@Valid
	private Doctor referredTo;

	@NotNull(message = "{referral.patient.notNull}")
	@Valid
	private Patient patient;

	@Valid
	private MedicalCase medicalCase;

	private Boolean completeCase;

	private Boolean includeAttachments;

	private Boolean patientAddedByDoctor;

	@Valid
	private Set<ReferredVisit> referredVisits;
	
	@Valid
	private Set<ReferredProcedure> referredProcedures;
	
//	@Valid
//	private Set<ReferredPosas> referredPosas;
	
	@Valid
	private Set<ReferredGiqli> referredGiqlis;
	
	private Date referredOn;

//	private Set<TenantReferralMapping> tenantReferralMappings;

	public Referral()
	{

	}

	public Referral(final Long id)
	{
		this.id = id;
	}

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

	@ManyToOne
	@JoinColumn(name = "Reffered_By", referencedColumnName = "Id", nullable = false)
	public Doctor getReferredBy()
	{
		return referredBy;
	}

	public void setReferredBy(Doctor referredBy)
	{
		this.referredBy = referredBy;
	}

	@ManyToOne
	@JoinColumn(name = "Reffered_To", referencedColumnName = "Id", nullable = false)
	public Doctor getReferredTo()
	{
		return referredTo;
	}

	public void setReferredTo(Doctor referredTo)
	{
		this.referredTo = referredTo;
	}

	@ManyToOne
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id", nullable = false)
	public Patient getPatient()
	{
		return patient;
	}

	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}

	@ManyToOne
	@JoinColumn(name = "Case_Id", referencedColumnName = "Id", nullable = true)
	public MedicalCase getMedicalCase()
	{
		return medicalCase;
	}

	public void setMedicalCase(MedicalCase medicalCase)
	{
		this.medicalCase = medicalCase;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "referral_id", referencedColumnName = "Id")
	public Set<ReferredVisit> getReferredVisits()
	{
		return referredVisits;
	}
	public void setReferredVisits(Set<ReferredVisit> referredVisits)
	{
		this.referredVisits = referredVisits;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "referral_id", referencedColumnName = "Id")
	public Set<ReferredProcedure> getReferredProcedures() {
		return referredProcedures;
	}

	public void setReferredProcedures(Set<ReferredProcedure> referredProcedures) {
		this.referredProcedures = referredProcedures;
	}
//
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "referral")
//	public Set<ReferredPosas> getReferredPosas() {
//		return referredPosas;
//	}
//
//	public void setReferredPosas(Set<ReferredPosas> referredPosas) {
//		this.referredPosas = referredPosas;
//	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "referral_id", referencedColumnName = "Id")
	public Set<ReferredGiqli> getReferredGiqlis() {
		return referredGiqlis;
	}

	public void setReferredGiqlis(Set<ReferredGiqli> referredGiqlis) {
		this.referredGiqlis = referredGiqlis;
	}

	@Column(name = "Complete_Case")
	public Boolean getCompleteCase()
	{
		return completeCase;
	}

	public void setCompleteCase(Boolean completeCase)
	{
		this.completeCase = completeCase;
	}

	@Column(name = "Patient_Added_By_Doctor", nullable = false)
	public Boolean getPatientAddedByDoctor()
	{
		return patientAddedByDoctor;
	}

	public void setPatientAddedByDoctor(Boolean patientAddedByDoctor)
	{
		this.patientAddedByDoctor = patientAddedByDoctor;
	}

	@Column(name = "Include_Attachments")
	public Boolean getIncludeAttachments()
	{
		return includeAttachments;
	}

	public void setIncludeAttachments(Boolean includeAttachments)
	{
		this.includeAttachments = includeAttachments;
	}


	@Column(name = "Referred_On", nullable = false)
	public Date getReferredOn()
	{
		return referredOn;
	}

	public void setReferredOn(Date referredOn)
	{
		this.referredOn = referredOn;
	}

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "referral")
//	@JSON(include = false)
//	@JsonIgnore
//	public Set<TenantReferralMapping> getTenantReferralMappings()
//	{
//		return tenantReferralMappings;
//	}
//
//	public void setTenantReferralMappings(Set<TenantReferralMapping> tenantReferralMappings)
//	{
//		this.tenantReferralMappings = tenantReferralMappings;
//	}

//	public void mapTenant(Tenant tenant)
//	{
//		if (this.tenantReferralMappings == null)
//		{
//			this.tenantReferralMappings = new LinkedHashSet<TenantReferralMapping>();
//		}
//		this.tenantReferralMappings.add(new TenantReferralMapping(tenant, this));
//	}

	public Referral withId()
	{
		return new Referral(this.id);
	}

}
