package com.pytosoft.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.pytosoft.model.DiagnosedDisease;
import com.pytosoft.model.ObservedComplain;
import com.pytosoft.model.PrescribedDiagnosis;
import com.pytosoft.model.PrescribedMedicine;
import com.pytosoft.model.procedure.CapturedVital;
import com.pytosoft.model.procedure.PrescribedLabTest;
import com.pytosoft.model.procedure.VisitAttachment;

import flexjson.JSON;

public class VisitVO implements Serializable
{
	private static final long serialVersionUID = 2868839854938894677L;

	private Integer id;

	private Date date;

	private String reasonForVisit;

	private ClinicVO clinic;

	private DoctorVO doctor;

	private MedicalCaseVO medicalCase;

	private AppointmentVO appointment;

	private String clinicalNote;

	private String examinationNote;

	private String additionalInstructions;

	private Set<PrescribedDiagnosis> prescribedDiagnosises;

	private Set<PrescribedLabTest> prescribedLabTests;

	private Set<PrescribedMedicine> prescribedMedicines;

	private Set<ObservedComplain> observedComplains;

	private Set<DiagnosedDisease> diagnosedDisease;

	private boolean generateMedPrescription;

	private boolean generateLabPrescription;

	private Set<Long> invoiceIds;

	private List<VisitAttachment> visitAttachments;

	private Set<CapturedVital> capturedVitals;

	private Date createdOn;

	public VisitVO() {

	}

	public VisitVO(Integer id) {
		super();
		this.id = id;
	}

	public VisitVO(Integer id, Date date) {
		this.id = id;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	@JSON(include = false)
	public ClinicVO getClinic() {
		return clinic;
	}

	public void setClinic(ClinicVO clinic) {
		this.clinic = clinic;
	}

	@JSON(include = false)
	public MedicalCaseVO getMedicalCase() {
		return medicalCase;
	}

	public void setMedicalCase(MedicalCaseVO medicalCase) {
		this.medicalCase = medicalCase;
	}

	@JSON(include = false)
	public Set<PrescribedDiagnosis> getPrescribedDiagnosises() {
		return prescribedDiagnosises;
	}

	@JSON(include = false)
	public void setPrescribedDiagnosises(Set<PrescribedDiagnosis> prescribedDiagnosises) {
		this.prescribedDiagnosises = prescribedDiagnosises;
	}

	@JSON(include = false)
	public Set<PrescribedMedicine> getPrescribedMedicines() {
		return prescribedMedicines;
	}

	@JSON(include = false)
	public void setPrescribedMedicines(Set<PrescribedMedicine> prescribedMedicines) {
		this.prescribedMedicines = prescribedMedicines;
	}

	@JSON(include = false)
	public Set<ObservedComplain> getObservedComplains() {
		return observedComplains;
	}

	public void setObservedComplains(Set<ObservedComplain> observedComplains) {
		this.observedComplains = observedComplains;
	}

	@JSON(include = false)
	public String getClinicalNote() {
		return clinicalNote;
	}

	public void setClinicalNote(String clinicalNote) {
		this.clinicalNote = clinicalNote;
	}

	@JSON(include = false)
	public boolean isGenerateMedPrescription() {
		return generateMedPrescription;
	}

	public void setGenerateMedPrescription(boolean generateMedPrescription) {
		this.generateMedPrescription = generateMedPrescription;
	}

	@JSON(include = false)
	public boolean isGenerateLabPrescription() {
		return generateLabPrescription;
	}

	public void setGenerateLabPrescription(boolean generateLabPrescription) {
		this.generateLabPrescription = generateLabPrescription;
	}

	@JSON(include = false)
	public Set<Long> getInvoiceIds() {
		return invoiceIds;
	}

	public void setInvoiceIds(Set<Long> invoiceIds) {
		this.invoiceIds = invoiceIds;
	}

	@JSON(include = false)
	public Set<DiagnosedDisease> getDiagnosedDisease() {
		return diagnosedDisease;
	}

	public void setDiagnosedDisease(Set<DiagnosedDisease> diagnosedDisease) {
		this.diagnosedDisease = diagnosedDisease;
	}

	@JSON(include = false)
	public List<VisitAttachment> getVisitAttachments() {
		return visitAttachments;
	}

	public void setVisitAttachments(List<VisitAttachment> visitAttachments2) {
		this.visitAttachments = visitAttachments2;
	}

	@JSON(include = false)
	public DoctorVO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorVO doctor) {
		this.doctor = doctor;
	}

	@JSON(include = false)
	public String getExaminationNote() {
		return examinationNote;
	}

	public void setExaminationNote(String examinationNote) {
		this.examinationNote = examinationNote;
	}

	@JSON(include = false)
	public String getAdditionalInstructions() {
		return additionalInstructions;
	}

	public void setAdditionalInstructions(String additionalInstructions) {
		this.additionalInstructions = additionalInstructions;
	}

	@JSON(include = false)
	public AppointmentVO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentVO appointment) {
		this.appointment = appointment;
	}

	@JSON(include = false)
	public Set<PrescribedLabTest> getPrescribedLabTests() {
		return prescribedLabTests;
	}

	public void setPrescribedLabTests(Set<PrescribedLabTest> prescribedLabTests) {
		this.prescribedLabTests = prescribedLabTests;
	}

	public Set<CapturedVital> getCapturedVitals() {
		return capturedVitals;
	}

	public void setCapturedVitals(Set<CapturedVital> capturedVitals) {
		this.capturedVitals = capturedVitals;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}