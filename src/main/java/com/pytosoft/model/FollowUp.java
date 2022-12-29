package com.pytosoft.model;

import java.util.Date;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "follow_up")
public class FollowUp 
{

   //private static final long serialVersionUID = -668206215797691311L;

	public static final String FP_FOLLOWUP_PATIENT = "fp_followup_patient";

	public static final String FOLLOW_UP_DATE = "followUpDate";

	public static final String FOLLOWED_BY_DOCTOR = "followedByDoctor";

	public static final String PATIENT = "patient";

	private Long id;

	@NotNull(message = "{followUp.patient.notNull}")
	private Patient patient;

	private Doctor followedByDoctor;

	/*
	 * @NotNull(message = "{followUp.followUpDate.notNull}")
	 * 
	 * @Future(message = "{followUp.followUpDate.future}")
	 */
	@NotNull(message = "{followUp.date}")
	private Date followUpDate;

	
	/*
	 * @NotBlank(message = "{followUp.comment.notBlank}")
	 * 
	 * @Size(max = 255, min = 10, message = "{followUp.comment.size}")
	 */
	 
	private String comment;

	private Date createdOn;

	//private MedicalCase medicalCase;

	//private Tenant tenant;

	public FollowUp()
	{

	}

	public FollowUp(Long id)
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
	
	
	@ManyToOne(/*optional = false*/ cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	public Patient getPatient()
	{
		return patient;
	}

	@ManyToOne(/* optional = false, */cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Followed_By_Doctor", referencedColumnName = "id")
	public Doctor getFollowedByDoctor()
	{
		return followedByDoctor;
	}

	@Column(name = "FollowUp_Date", nullable = false)
	public Date getFollowUpDate()
	{
		return followUpDate;
	}

	@Column(name = "Comment", length = 255)
	public String getComment()
	{
		return comment;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}

	public void setFollowedByDoctor(Doctor followedByDoctor)
	{
		this.followedByDoctor = followedByDoctor;
	}


	public void setFollowUpDate(Date followUpDate)
	{
		this.followUpDate = followUpDate;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
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

//	@ManyToOne(optional = true)
//	@JoinColumn(name = "Medical_Case_Id", referencedColumnName = "Id")
//	public MedicalCase getMedicalCase()
//	{
//		return medicalCase;
//	}
//
//	public void setMedicalCase(MedicalCase medicalCase)
//	{
//		this.medicalCase = medicalCase;
//	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Tenant_Id", referencedColumnName = "Id")
//

//	public Tenant getTenant()
//	{
//		return tenant;
//	}
//
//	public void setTenant(Tenant tenant)
//	{
//		this.tenant = tenant;
//	}
//
//	public void setTenant(Tenant tenant) {
//		// TODO Auto-generated method stub
//		
//	}
}
