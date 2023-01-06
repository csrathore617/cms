package com.pytosoft.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.pytosoft.constants.UpdateAppointment;
import com.pytosoft.model.Giqli;
import com.pytosoft.model.procedure.Procedure;

import flexjson.JSON;

public class MedicalCaseVO implements Serializable
{

	private static final long serialVersionUID = 7155051168445578583L;

	@NotNull(groups = { UpdateAppointment.class }, message = "{medicalCase.id.notNull}")
	@Min(groups = { UpdateAppointment.class }, value = 1, message = "{medicalCase.id.min}")
	private Integer id;

	private String name;

	private String comments;

	private String tags;

	private Date lastVisitDate;

	private PatientVO patient;

	private DoctorVO doctor;

	private List<VisitVO> visits;
	
	private List<Procedure> procedures;
	
//	private List<Posas> posas;
	
	private List<Giqli> giqlis;

	private Date visitedOn;

//	private List<PatientsAttachment> patientsAttachments;

	public MedicalCaseVO() {

	}

	public MedicalCaseVO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@JSON(include = false)
	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	@JSON(include = false)
	public PatientVO getPatient() {
		return patient;
	}

	public void setPatient(PatientVO patient) {
		this.patient = patient;
	}

	@JSON(include = false)
	public DoctorVO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorVO doctor) {
		this.doctor = doctor;
	}

	@JSON(include = false)
	public List<VisitVO> getVisits() {
		return visits;
	}

	public void setVisits(List<VisitVO> visits) {
		this.visits = visits;
	}

	public Date getVisitedOn() {
		return visitedOn;
	}

	public void setVisitedOn(Date visitedOn) {
		this.visitedOn = visitedOn;
	}

//	public List<PatientsAttachment> getPatientsAttachments() {
//		return patientsAttachments;
//	}
//
//	public void setPatientsAttachments(List<PatientsAttachment> patientsAttachments) {
//		this.patientsAttachments = patientsAttachments;
//	}

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

//	public List<Posas> getPosas() {
//		return posas;
//	}
//
//	public void setPosas(List<Posas> posas) {
//		this.posas = posas;
//	}

	public List<Giqli> getGiqlis() {
		return giqlis;
	}

	public void setGiqlis(List<Giqli> giqlis) {
		this.giqlis = giqlis;
	}
}
