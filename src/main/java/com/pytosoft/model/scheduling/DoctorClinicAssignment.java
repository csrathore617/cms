package com.pytosoft.model.scheduling;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.model.Clinic;
import com.pytosoft.model.Doctor;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor_clinic_assignment")
public class DoctorClinicAssignment {
	public static final String CLINIC = "clinic";

	public static final String DOCTOR = "doctor";

	public static final byte DEFAULT_MAX_BOOKING_PER_SLOT = 4;

	public static final String ONLINE_APPOINTMENT_ENABLED = "onlineAppointmment";

	public static final String ACTIVE = "active";

	public static final String SCHEDULE_PREPARED = "schedulePrepared";

	public static final String ID = "id";

	@NotNull(message = "{doctorClinicAssignment.id.notNull}")
	@Min(value = 1, message = "{doctorClinicAssignment.id.min}")
	private Long id;

	//@NotNull(message = "{doctorClinicAssignment.doctor.notNull}")
	@Valid
	private Doctor doctor;

	@NotNull(message = "{doctorClinicAssignment.clinic.notNull}")
	@Valid
	private Clinic clinic;

	private Date assignedOn;

	private boolean active;

	private boolean onlineAppointmment;

	@Min(value = 0, message = "{doctorClinicAssignment.maxBookingsPerSlot.min}")
	@Max(value = 10, message = "{doctorClinicAssignment.maxBookingsPerSlot.max}")
	private byte maxBookingsPerSlot;

	private boolean schedulePrepared;

	public DoctorClinicAssignment() {

	}

	public DoctorClinicAssignment(Long id) {
		super();
		this.id = id;
	}

	public DoctorClinicAssignment(Doctor doctor, Clinic clinic) {
		super();
		this.doctor = doctor;
		this.clinic = clinic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY, /* optional = false, */ cascade = CascadeType.ALL)
	@JoinColumn(name = "Doctor_Id", referencedColumnName = "id")
	public Doctor getDoctor() {
		return doctor;
	}

	@ManyToOne(fetch = FetchType.LAZY, /* optional = false, */ cascade = CascadeType.ALL)
	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id")
	public Clinic getClinic() {
		return clinic;
	}

	@Column(name = "Assigned_Date"/* , nullable = false */)
	public Date getAssignedOn() {
		return assignedOn;
	}

	@Column(name = "Active", nullable = false)
	@Value("true")
	public boolean isActive() {
		return active;
	}

	@Column(name = "Online_Appointmment", nullable = false)
	@Value("true")
	public boolean isOnlineAppointmment() {
		return onlineAppointmment;
	}

	@Column(name = "Max_Bookings_Per_Slot", nullable = false)
	@Value("1")
	public byte getMaxBookingsPerSlot() {
		return maxBookingsPerSlot;
	}

	public void setMaxBookingsPerSlot(byte maxBookingsPerSlot) {
		this.maxBookingsPerSlot = maxBookingsPerSlot;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setAssignedOn(Date assignedOn) {
		this.assignedOn = assignedOn;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setOnlineAppointmment(boolean onlineAppointmment) {
		this.onlineAppointmment = onlineAppointmment;
	}

	@Column(name = "Schedule_Prepared", nullable = false)
	public boolean isSchedulePrepared() {
		return schedulePrepared;
	}

	public void setSchedulePrepared(boolean schedulePrepared) {
		this.schedulePrepared = schedulePrepared;
	}

}
