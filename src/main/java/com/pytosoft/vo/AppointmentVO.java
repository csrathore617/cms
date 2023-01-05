package com.pytosoft.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constants.AppointmentStatus;
import com.pytosoft.constants.ChangeLocation;
import com.pytosoft.constants.CreateAppointment;
import com.pytosoft.constants.CreateLabAppointment;
import com.pytosoft.constants.UpdateAppointment;
import com.pytosoft.constants.UpdateLabAppointment;
import com.pytosoft.constraint.Alpha;
import com.pytosoft.constraint.NotHtml;
import com.pytosoft.model.billing.BillableService;
import com.pytosoft.util.JsonDateDeserializer;
import com.pytosoft.util.JsonTimeDeserializer;

import flexjson.JSON;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class AppointmentVO implements Serializable
{

	private static final long serialVersionUID = -8159817112973998928L;

	@NotNull(groups = { UpdateAppointment.class,UpdateLabAppointment.class }, message = "{appointment.id.notNull}")
	@Min(groups = { UpdateAppointment.class,UpdateLabAppointment.class }, value = 1, message = "{appointment.id.min}")
	private Long id;
	
	@NotNull(groups = {CreateAppointment.class,UpdateAppointment.class,CreateLabAppointment.class ,UpdateLabAppointment.class}, message = "{appointment.patient.notNull}")
	private PatientVO patient;

	private DoctorVO doctor;

	@Valid
	private MedicalCaseVO medicalCase;
	
	private boolean newCase;

	@NotNull(groups = { CreateAppointment.class,UpdateAppointment.class,ChangeLocation.class }, message = "{appointment.clinic.notNull}")
	@Valid
	private ClinicVO clinic;

	private AppointmentStatus status;

	@NotNull(groups = {CreateAppointment.class,UpdateAppointment.class,CreateLabAppointment.class ,UpdateLabAppointment.class},message = "{appointment.appointmentDate.notNull}")
	//@Future(groups = {CreateAppointment.class,UpdateAppointment.class },message = "{appointment.appointmentDate.future}")
	private Date appointmentDate;

	@Size(groups = {CreateAppointment.class,UpdateAppointment.class,CreateLabAppointment.class ,UpdateLabAppointment.class},max = 255, message = "{appointment.reasonForVisit.size}")
	@NotHtml(groups = {CreateAppointment.class,UpdateAppointment.class ,CreateLabAppointment.class,UpdateLabAppointment.class},message = "{appointment.reasonForVisit.notHtml}")
	private String reasonForVisit;

	private VisitVO visit;

	@Size(max = 100, message = "{appointment.cancellationReason.size}")
	private String cancellationReason;
	
	@NotNull(groups = {CreateAppointment.class,UpdateAppointment.class,CreateLabAppointment.class ,UpdateLabAppointment.class},message = "{appointment.startTime.notNull}")
	private Date startTime;

	@NotNull(groups = {CreateAppointment.class,UpdateAppointment.class,CreateLabAppointment.class ,UpdateLabAppointment.class},message = "{appointment.endTime.notNull}")
	private Date endTime;
	
	@Valid
	private BillableService billableService;
	
	@Size(groups = {CreateAppointment.class,UpdateAppointment.class,CreateLabAppointment.class ,UpdateLabAppointment.class},max = 100, message = "{appointment.referredBy.size}")
	@Alpha(groups = {CreateAppointment.class,UpdateAppointment.class,CreateLabAppointment.class ,UpdateLabAppointment.class},message = "{appointment.referredBy.regex}")
	private String referredBy;
	
	private Boolean walkin;

	@JSON(include = false)
	public DoctorVO getDoctor()
	{
		return doctor;
	}

	public void setDoctor(DoctorVO doctor)
	{
		this.doctor = doctor;
	}

	public AppointmentVO()
	{

	}

	public AppointmentVO(Long id)
	{
		this.id = id;
	}

	public AppointmentVO(Long id, Date appointmentDate)
	{
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
	}

	public AppointmentVO(Long id, String reasonForVisit, PatientVO patient, AppointmentStatus status)
	{
		this.id = id;
		this.reasonForVisit = reasonForVisit;
		this.patient = patient;
		this.status = status;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@JSON(include = false)
	public String getReasonForVisit()
	{
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit)
	{
		this.reasonForVisit = reasonForVisit;
	}

	@JSON(include = false)
	public PatientVO getPatient()
	{
		return patient;
	}

	public void setPatient(PatientVO patient)
	{
		this.patient = patient;
	}

	public AppointmentStatus getStatus()
	{
		return status;
	}

	public void setStatus(AppointmentStatus status)
	{
		this.status = status;
	}

	public Date getAppointmentDate()
	{
		return appointmentDate;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setAppointmentDate(Date appointmentDate)
	{
		this.appointmentDate = appointmentDate;
	}

	@JSON(include = false)
	public MedicalCaseVO getMedicalCase()
	{
		return medicalCase;
	}

	public void setMedicalCase(MedicalCaseVO medicalCase)
	{
		this.medicalCase = medicalCase;
	}

	@JSON(include = false)
	public ClinicVO getClinic()
	{
		return clinic;
	}

	public void setClinic(ClinicVO clinic)
	{
		this.clinic = clinic;
	}

	@JSON(include = false)
	public String getCancellationReason()
	{
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason)
	{
		this.cancellationReason = cancellationReason;
	}

	@JSON(include = false)
	public VisitVO getVisit()
	{
		return visit;
	}

	public void setVisit(VisitVO visitVO)
	{
		this.visit = visitVO;
	}

	@Temporal(TemporalType.TIME)
	public Date getStartTime() {
		return startTime;
	}

	@JsonDeserialize(using = JsonTimeDeserializer.class)
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.TIME)
	public Date getEndTime() {
		return endTime;
	}

	@JsonDeserialize(using = JsonTimeDeserializer.class)
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BillableService getBillableService() {
		return billableService;
	}

	public void setBillableService(BillableService billableService) {
		this.billableService = billableService;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public boolean isNewCase() {
		return newCase;
	}

	public void setNewCase(boolean newCase) {
		this.newCase = newCase;
	}

	public Boolean getWalkin() {
		return walkin;
	}

	public void setWalkin(Boolean walkin) {
		this.walkin = walkin;
	}
}
