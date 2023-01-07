package com.pytosoft.model.procedure;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import org.springframework.cglib.core.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constants.DatePattern;
import com.pytosoft.constraint.OperativeParamComparator;
import com.pytosoft.model.Appointment;
import com.pytosoft.model.Clinic;
import com.pytosoft.model.DiagnosedDisease;
import com.pytosoft.model.MedicalCase;
import com.pytosoft.model.ObservedComplain;
import com.pytosoft.model.PrescribedMedicine;
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
@Table(name = "visit_procedure")
public class Procedure 
{

	private Integer id;

	
	private Date date;

	
//	@ManyToOne(optional = false, fetch = FetchType.LAZY)
//	@JoinColumn(name = "Medical_Case_id", referencedColumnName = "Id")
//	private MedicalCase medicalCase;

	
	
	private Clinic clinic;

	private Appointment appointment;
	
	private String procedureName;
	
	private String procedureNote;
	
	private String participantName;

	private Date createdOn;

	
//	private Set<PrescribedLabTest> prescribedLabTests;

	
	private Set<PrescribedMedicine> prescribedMedicines;

	
	private Set<ObservedComplain> observedComplains;

	
	private Set<DiagnosedDisease> diagnosedDiseases;
	
	
	private Set<CapturedVital> capturedVitals;
	
	
//	private Set<ImplantTaken> implantsTaken;
	
		
	@JsonDeserialize(as=SortedSet.class)
	private SortedSet<OperativeParamValue> operativeParamValues;

	private List<Long> procedureAttachment;

	
	private List<VisitAttachment> visitAttachments;
	
	private String duration;

	public Procedure()
	{

	}

	public Procedure(Integer id)
	{
		super();
		this.id = id;
	}

	@Column(name = "Procedure_Date", nullable = false)
	public Date getDate()
	{
		return date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	
//	public MedicalCase getMedicalCase()
//	{
//		return medicalCase;
//	}
//
//	public void setMedicalCase(MedicalCase medicalCase)
//	{
//		this.medicalCase = medicalCase;
//	}
	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id")
	public Clinic getClinic()
	{
		return clinic;
	}

	public void setClinic(Clinic clinic)
	{
		this.clinic = clinic;
	}

	@Column(name = "procedure_name", nullable = true, length = 1000)
	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	@Column(name = "procedure_note", nullable = true, length = 2000)
	public String getProcedureNote() {
		return procedureNote;
	}

	public void setProcedureNote(String procedureNote) {
		this.procedureNote = procedureNote;
	}

	@Column(name = "participant_name", nullable = true, length = 2000)
	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id", nullable = true)
	@OrderBy(PrescribedMedicine.ORDERING)
	public Set<PrescribedMedicine> getPrescribedMedicines()
	{
		return prescribedMedicines;
	}

	public void setPrescribedMedicines(Set<PrescribedMedicine> prescribedMedicines)
	{
		this.prescribedMedicines = prescribedMedicines;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id", nullable = true)
	@OrderBy(ObservedComplain.ORDERING)
	public Set<ObservedComplain> getObservedComplains()
	{
		return observedComplains;
	}

	public void setObservedComplains(Set<ObservedComplain> observedComplains)
	{
		this.observedComplains = observedComplains;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id", nullable = true)
	@OrderBy(DiagnosedDisease.ORDERING)
	public Set<DiagnosedDisease> getDiagnosedDiseases()
	{
		return diagnosedDiseases;
	}

	public void setDiagnosedDiseases(Set<DiagnosedDisease> diagnosedDiseases)
	{
		this.diagnosedDiseases = diagnosedDiseases;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Appointment_Id", referencedColumnName = "Id")
	public Appointment getAppointment()
	{
		return appointment;
	}

	public void setAppointment(Appointment appointment)
	{
		this.appointment = appointment;
	}

	// for ui only
	@Transient
	public List<Long> getProcedureAttachment() {
		return procedureAttachment;
	}

	public void setProcedureAttachment(List<Long> procedureAttachment) {
		this.procedureAttachment = procedureAttachment;
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

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "procedure")
//	@OrderBy(PrescribedLabTest.ORDERING)
//	public Set<PrescribedLabTest> getPrescribedLabTests()
//	{
//		return prescribedLabTests;
//	}
//
//	public void setPrescribedLabTests(Set<PrescribedLabTest> prescribedLabTests)
//	{
//		this.prescribedLabTests = prescribedLabTests;
//	}

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "procedure") public Set<CapturedVital> getCapturedVitals() { return
	 * capturedVitals; }
	 * 
	 * public void setCapturedVitals(Set<CapturedVital> capturedVitals) {
	 * this.capturedVitals = capturedVitals; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "procedure")
	 * 
	 * @OrderBy(ImplantTaken.ORDERING) public Set<ImplantTaken> getImplantsTaken() {
	 * return implantsTaken; }
	public void setImplantsTaken(Set<ImplantTaken> implantsTaken) {
		this.implantsTaken = implantsTaken;
	}
	 */

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY/* , mappedBy = "procedure" */)
//	@Sort(comparator = OperativeParamComparator.class, type = SortType.COMPARATOR)
	public SortedSet<OperativeParamValue> getOperativeParamValues()
	{
		return operativeParamValues;
	}

	public void setOperativeParamValues(
			SortedSet<OperativeParamValue> operativeParamValues) {
		this.operativeParamValues = operativeParamValues;
	}


	/*
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "procedure") // @JSON(include = false)
	 * 
	 * @JsonIgnore public Set<TenantProcedureMapping> getTenantProcedureMappings() {
	 * return tenantProcedureMappings; }
	 * 
	 * public void setTenantProcedureMappings(Set<TenantProcedureMapping>
	 * tenantProcedureMappings) { this.tenantProcedureMappings =
	 * tenantProcedureMappings; }
	 */

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id", nullable = true)
	public List<VisitAttachment> getVisitAttachments() {
		return visitAttachments;
	}

	public void setVisitAttachments(List<VisitAttachment> visitAttachments) {
		this.visitAttachments = visitAttachments;
	}
	
	@Transient
	public String getDuration() {
		return duration;
	}

	/*
	 * public void setDuration() { Date operationStart = null; Date operationEnd =
	 * null; if (CollectionUtils.isNotEmpty(operativeParamValues)) { for
	 * (OperativeParamValue operativeParamValue : operativeParamValues) { if
	 * (OPERATION_START.equals(operativeParamValue.getOperativeParam().getName())&&
	 * operativeParamValue.getValue()!=null) { operationStart =
	 * parseToDate(operativeParamValue.getValue()); } if
	 * (OPERATION_END.equals(operativeParamValue.getOperativeParam().getName())&&
	 * operativeParamValue.getValue()!=null) { operationEnd =
	 * parseToDate(operativeParamValue.getValue()); } } if ((operationStart != null)
	 * && (operationEnd != null)) { Long difference = operationEnd.getTime() -
	 * operationStart.getTime(); if (difference != null) { duration =
	 * DurationFormatUtils.formatDuration(difference, "HH:mm"); } } if (duration !=
	 * null) { OperativeParam operativeParam = new OperativeParam(DURATION_LITERAL,
	 * OperativeParamType.Value, 3); OperativeParamValue operativeParamValue = new
	 * OperativeParamValue(duration+" "+HOURS_LITERAL, operativeParam);
	 * operativeParamValues.add(operativeParamValue); } } }
	 */
	
	public boolean hasId()
	{
		return getId() != null && getId() > 0;
	}



	/*
	 * public void merge(Procedure procedure) {
	 * setParticipantName(procedure.getParticipantName());
	 * setProcedureName(procedure.getProcedureName());
	 * setProcedureNote(procedure.getProcedureNote());
	 * 
	 * if (CollectionUtils.isNotEmpty(procedure.getDiagnosedDiseases())) {
	 * Set<DiagnosedDisease> diagnosedDiseases = getDiagnosedDiseases();
	 * diagnosedDiseases.addAll(procedure.getDiagnosedDiseases());
	 * setDiagnosedDiseases(diagnosedDiseases); } if
	 * (CollectionUtils.isNotEmpty(procedure.getObservedComplains())) {
	 * Set<ObservedComplain> observedComplains = getObservedComplains();
	 * observedComplains.addAll(procedure.getObservedComplains());
	 * setObservedComplains(observedComplains); } if
	 * (CollectionUtils.isNotEmpty(procedure.getPrescribedMedicines())) {
	 * getPrescribedMedicines().addAll(procedure.getPrescribedMedicines()); } if
	 * (CollectionUtils.isNotEmpty(procedure.getPrescribedLabTests())) { for
	 * (PrescribedLabTest currentLabTest : procedure.getPrescribedLabTests()) {
	 * currentLabTest.setProcedure(this); currentLabTest.setPrescriptionDate(new
	 * Date()); } getPrescribedLabTests().addAll(procedure.getPrescribedLabTests());
	 * }
	 * 
	 * if (CollectionUtils.isNotEmpty(procedure.getCapturedVitals())) { for
	 * (CapturedVital capturedVital : procedure.getCapturedVitals()) {
	 * capturedVital.setProcedure(this); }
	 * getCapturedVitals().addAll(procedure.getCapturedVitals()); }
	 * 
	 * if (CollectionUtils.isNotEmpty(procedure.getImplantsTaken())) { for
	 * (ImplantTaken implantTaken : procedure.getImplantsTaken()) {
	 * implantTaken.setProcedure(this); }
	 * getImplantsTaken().addAll(procedure.getImplantsTaken()); }
	 * 
	 * if (CollectionUtils.isNotEmpty(procedure.getOperativeParamValues())) { for
	 * (OperativeParamValue operativeParamValue :
	 * procedure.getOperativeParamValues()) {
	 * operativeParamValue.setProcedure(this); }
	 * getOperativeParamValues().addAll(procedure.getOperativeParamValues()); } }
	 */
	
	private Date parseToDate(String date) {
		DateFormat sdf = new SimpleDateFormat(DatePattern.ONLY_TIME.getPattern());
		Date parsedDateTime = null;
		try {
			parsedDateTime = sdf.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return parsedDateTime;
	}

}
