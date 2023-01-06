package com.pytosoft.model;




import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constants.AppointmentStatus;
import com.pytosoft.model.billing.BillableService;
import com.pytosoft.model.lab.LabOrder;
import com.pytosoft.model.procedure.Procedure;
import com.pytosoft.model.scheduling.BookingTimeSlot;
import com.pytosoft.model.scheduling.DoctorClinicAssignment;
import com.pytosoft.util.JsonDateDeserializer;
import com.pytosoft.util.JsonTimeDeserializer;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "appointment")
public class Appointment {

	private Long id;

	private String reasonForVisit;

	private Patient patient;

	private AppointmentStatus status;

	private Date createdOn;

	private Date updatedOn;

	private String cancellationReason;

//	private Visit visit;

//	private Procedure procedure;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "Booking_Time_Slot_Id", referencedColumnName = "Id")
	private BookingTimeSlot bookingTimeSlot;

	private DoctorClinicAssignment doctorClinicAssignment;

	private Date appointmentDate;

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Medical_Case_Id", referencedColumnName = "Id")
//	private MedicalCase medicalCase;

	private boolean newCase;

	private boolean notificationPriorTo24HourSent;

	private boolean notificationPriorTo1HourSent;

	private boolean cancelledWhileUpdateSchedule;

	
	private Date startTime;

	private Date endTime;

	private BillableService billableService;

	private String referredBy;

	private Boolean walkin;

	private LabOrder labOrder;

	public Appointment() {

	}

	public Appointment(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long getId() {
		return id;
	}

	@Column(name = "Reason_For_Visit", length = 255)
	public String getReasonForVisit() {
		return reasonForVisit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	public Patient getPatient() {
		return patient;
	}

	@Column(name = "Status", nullable = false)
	@Enumerated(EnumType.STRING)
	public AppointmentStatus getStatus() {
		return status;
	}

	@Column(name = "Created_On",nullable = true)
	public Date getCreatedOn() {
		return createdOn;
	}

	@Column(name = "Updated_On")
	public Date getUpdatedOn() {
		return updatedOn;
	}

	@Column(name = "Cancellation_Reason", length = 100)
	public String getCancellationReason() {
		return cancellationReason;
	}

	
//	public BookingTimeSlot getBookingTimeSlot() {
//		return bookingTimeSlot;
//	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Doctor_Clinic_Assignment_Id", referencedColumnName = "Id")
	public DoctorClinicAssignment getDoctorClinicAssignment() {
		return doctorClinicAssignment;
	}

	@Column(name = "Appointment_Date", nullable = true)
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setDoctorClinicAssignment(DoctorClinicAssignment doctorClinicAssignment) {
		this.doctorClinicAssignment = doctorClinicAssignment;
	}

//	public void setBookingTimeSlot(BookingTimeSlot bookingTimeSlot) {
//		this.bookingTimeSlot = bookingTimeSlot;
//	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}


//	public MedicalCase getMedicalCase() {
//		return medicalCase;
//	}
//
//	public void setMedicalCase(MedicalCase medicalCase) {
//		this.medicalCase = medicalCase;
//	}

	@Column(name = "NewCase", nullable = false)
	public boolean isNewCase() {
		return newCase;
	}

	public void setNewCase(boolean newCase) {
		this.newCase = newCase;
	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id")
//	public Visit getVisit() {
//		return visit;
//	}
//
//	public void setVisit(Visit visit) {
//		this.visit = visit;
//	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id")
//	public Procedure getProcedure() {
//		return procedure;
//	}

//	public void setProcedure(Procedure procedure) {
//		this.procedure = procedure;
//	}

	@Column(name = "Notification_Prior_To_24Hour_Sent")
	public boolean isNotificationPriorTo24HourSent() {
		return notificationPriorTo24HourSent;
	}

	public void setNotificationPriorTo24HourSent(boolean notificationPriorTo24HourSent) {
		this.notificationPriorTo24HourSent = notificationPriorTo24HourSent;
	}

	@Column(name = "Notification_Prior_To_1Hour_Sent")
	public boolean isNotificationPriorTo1HourSent() {
		return notificationPriorTo1HourSent;
	}

	public void setNotificationPriorTo1HourSent(boolean notificationPriorTo1HourSent) {
		this.notificationPriorTo1HourSent = notificationPriorTo1HourSent;
	}

	@Column(name = "Cancelled_While_Update_Schedule")
	public boolean isCancelledWhileUpdateSchedule() {
		return cancelledWhileUpdateSchedule;
	}

	public void setCancelledWhileUpdateSchedule(boolean cancelledWhileUpdateSchedule) {
		this.cancelledWhileUpdateSchedule = cancelledWhileUpdateSchedule;
	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Created_By", referencedColumnName = "Id")
//	public AppUser getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(AppUser createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Updated_By", referencedColumnName = "Id")
//	public AppUser getUpdatedBy() {
//		return updatedBy;
//	}
//
//	public void setUpdatedBy(AppUser updatedBy) {
//		this.updatedBy = updatedBy;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "appointment")
//	@JSON(include = false)
//	@JsonIgnore
//	public Set<TenantAppointmentMapping> getTenantAppointmentMappings() {
//		return tenantAppointmentMappings;
//	}
//
//	public void setTenantAppointmentMappings(Set<TenantAppointmentMapping> tenantAppointmentMappings) {
//		this.tenantAppointmentMappings = tenantAppointmentMappings;
//	}
//
//	public void mapTenant(Tenant tenant) {
//		if (this.tenantAppointmentMappings == null) {
//			this.tenantAppointmentMappings = new LinkedHashSet<TenantAppointmentMapping>();
//		}
//		this.tenantAppointmentMappings.add(new TenantAppointmentMapping(tenant, this));
//	}

	@Column(name = "Start_Time", nullable = true)
//	@Temporal(TemporalType.TIME)
	public Date getStartTime() {
		return startTime;
	}

//	@JsonDeserialize(using = JsonTimeDeserializer.class)
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "End_Time", nullable = true)
//	@Temporal(TemporalType.TIME)
	public Date getEndTime() {
		return endTime;
	}

//	@JsonDeserialize(using = JsonTimeDeserializer.class)
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true,cascade = CascadeType.ALL)
	@JoinColumn(name = "Billable_Service", referencedColumnName = "Id")
	public BillableService getBillableService() {
		return billableService;
	}

	public void setBillableService(BillableService billableService) {
		this.billableService = billableService;
	}

	@Column(name = "Referred_By", length = 100, nullable = true)
	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	@Column(name = "walkin", nullable = true)
	public Boolean getWalkin() {
		return walkin;
	}

	public void setWalkin(Boolean walkin) {
		this.walkin = walkin;
	}

	@OneToOne(mappedBy = "appointment", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name = "appointment_ID", referencedColumnName = "Id")
	public LabOrder getLabOrder() {
		return labOrder;
	}

	public void setLabOrder(LabOrder labOrder) {
		this.labOrder = labOrder;
	}
}