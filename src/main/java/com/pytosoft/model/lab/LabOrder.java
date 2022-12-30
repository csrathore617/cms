package com.pytosoft.model.lab;

import java.sql.Date;

import com.pytosoft.model.Appointment;
import com.pytosoft.model.Patient;
import com.pytosoft.model.v3.LabTestReferral;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "lab_order")
public class LabOrder {

	private Long id;

	private Date createdOn;

	private LabTestReferral labTestReferral;
//	private Set<LabOrderItem> labOrderItems;

//	private Patient patient;

//	private InvestigationStatus status;

//	private Set<LabOrderActivityHistory> labOrderActivityHistories;

//	private Invoice invoice;

	private Patient patientVO;

	private Appointment appointment;

	public LabOrder() {

	}

	public LabOrder(final Long id) {
		this.id = id;
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

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/*@Fetch(FetchMode.SELECT)
	@BatchSize(size = 20)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "labOrder")
	public Set<LabOrderItem> getLabOrderItems()
	{
		return labOrderItems;
	}

	public void setLabOrderItems(Set<LabOrderItem> labOrderItems)
	{
		this.labOrderItems = labOrderItems;
	}*/

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	public Patient getPatient() {
		return patientVO;
	}

	public void setPatient(Patient patient) {
		this.patientVO = patient;
	}

	/*@Column(name = "Status", nullable = false, length = 100)
	@Enumerated(EnumType.STRING)
	public InvestigationStatus getStatus()
	{
		return status;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "labOrder")
	public Set<LabOrderActivityHistory> getLabOrderActivityHistories()
	{
		return labOrderActivityHistories;
	}

	public void setLabOrderActivityHistories(Set<LabOrderActivityHistory> labOrderActivityHistories)
	{
		this.labOrderActivityHistories = labOrderActivityHistories;
	}*/

	/*@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Invoice_Id")
	public Invoice getInvoice()
	{
		return invoice;
	}*/

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Appointment_Id", referencedColumnName = "Id")
	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

//	 only for UI
	@Transient
	public Patient getPatientVO() {
		return patientVO;
	}

	public void setPatientVO(Patient patientVO) {
		this.patientVO = patientVO;
	}

	public boolean hasId() {
		return id != null && id > 0;
	}

	/*
	 *  business validation
	 * 
	 * @AssertTrue(groups = { LabOrderGeneration.class }, message =
	 * "{labOrder.labTestReferral.nonZero}") public boolean hasLabTestReferralId() {
	 * return labTestReferral != null && labTestReferral.hasId(); }
	 * 
	 * public boolean hasLabTestReferral() { return getLabTestReferral() != null; }
	 */

}
