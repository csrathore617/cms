package com.pytosoft.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.pytosoft.model.Address;
import com.pytosoft.model.AvailableFacility;
import com.pytosoft.model.ClinicSpecialization;
import com.pytosoft.model.scheduling.BookingTimeSlot;
import com.pytosoft.constants.*;

import flexjson.JSON;


public class ClinicVO implements Serializable
{
	private static final long serialVersionUID = 3839799066652544392L;

	@NotNull(groups = { CreateAppointment.class, UpdateAppointment.class, ChangeLocation.class,
			BookingSchedule.class }, message = "{clinic.id.notNull}")
	@Min(groups = { CreateAppointment.class, UpdateAppointment.class, ChangeLocation.class,
			BookingSchedule.class }, value = 1, message = "{clinic.id.min}")
	private Integer id;

	private String name;

	private Address address;

	private String email;

	private String fax1;

	private String fax2;

	private String modeOfPayment;

	private String ambulanceService;

	private String operatingDays1;

	private String operatingDays2;

	private String additionalNotes;

	private String phoneNumber1;

	private String phoneNumber2;

	private String phoneNumber3;

	private List<ClinicSpecialization> clinicSpecializations;

	private Long doctorClinicAssignmentId;

	private List<BookingTimeSlot> bookingTimeSlots;

	private String clincDistanceFromLocation;

	private Set<AvailableFacility> availableFacilities;

	private List<DoctorVO> doctorVOs;

	private Boolean hospital;
	
	private boolean active;
	

	public String getClincDistanceFromLocation() {
		return clincDistanceFromLocation;
	}

	public void setClincDistanceFromLocation(String clincDistanceFromLocation) {
		this.clincDistanceFromLocation = clincDistanceFromLocation;
	}

	@JSON(include = false)
	public List<BookingTimeSlot> getBookingTimeSlots() {
		return bookingTimeSlots;
	}

	public void setBookingTimeSlots(List<BookingTimeSlot> bookingTimeSlots) {
		this.bookingTimeSlots = bookingTimeSlots;
	}

	public ClinicVO() {

	}

	public ClinicVO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFax1() {
		return fax1;
	}

	public String getFax2() {
		return fax2;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}

	public String getOperatingDays1() {
		return operatingDays1;
	}

	public void setOperatingDays1(String operatingDays1) {
		this.operatingDays1 = operatingDays1;
	}

	public String getOperatingDays2() {
		return operatingDays2;
	}

	public void setOperatingDays2(String operatingDays2) {
		this.operatingDays2 = operatingDays2;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getAmbulanceService() {
		return ambulanceService;
	}

	public void setAmbulanceService(String ambulanceService) {
		this.ambulanceService = ambulanceService;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}

	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}

	public List<ClinicSpecialization> getClinicSpecializations() {
		return clinicSpecializations;
	}

	public void setClinicSpecializations(List<ClinicSpecialization> clinicSpecializations) {
		this.clinicSpecializations = clinicSpecializations;
	}

	public String toString() {
		return this.name + "::" + this.email + "::";
	}

	public Long getDoctorClinicAssignmentId() {
		return doctorClinicAssignmentId;
	}

	public void setDoctorClinicAssignmentId(Long doctorClinicAssignmentId) {
		this.doctorClinicAssignmentId = doctorClinicAssignmentId;
	}

	public void setAvailableFacilities(Set<AvailableFacility> availableFacilities) {
		this.availableFacilities = availableFacilities;

	}

	public Set<AvailableFacility> getAvailableFacilities() {
		return availableFacilities;
	}

	public List<DoctorVO> getDoctorVOs() {
		return doctorVOs;
	}

	public void setDoctorVOs(List<DoctorVO> doctorVOs) {
		this.doctorVOs = doctorVOs;
	}

	public Boolean getHospital() {
		return hospital;
	}
	

	public void setHospital(Boolean hospital) {
		this.hospital = hospital;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
