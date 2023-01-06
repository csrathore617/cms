package com.pytosoft.model.procedure;

import java.util.Date;
import java.util.SortedSet;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.pytosoft.model.Patient;
import com.pytosoft.model.Visit;

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
@Table(name = "captured_vital")
@BatchSize(size = 20)
public class CapturedVital /* implements SingleTenantOwned */
{
	private static final long serialVersionUID = 3677985084623366300L;

	public static final String VITAL_PARAM_VALUES = "vitalParamValues";

	public static final String ID = "id";
	
	public static final String PROCEDURE = "procedure";
	
	public static final String VISIT = "visit";

	private Long id;

	@NotNull(groups = { Default.class }, message = "{capturedVitals.vitalParamValues.notNull}")
	@Valid
	@JsonDeserialize(as=SortedSet.class)
	private SortedSet<VitalParamValue> vitalParamValues;
	
	private Procedure procedure;
	
	private Patient patient;
	
	private Visit visit;

//	private Tenant tenant;
	
	private Date createdOn;

	public CapturedVital()
	{

	}

	public CapturedVital(Long id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@Sort(comparator = VitalParamValueComparator.class, type = SortType.COMPARATOR)
	@JoinColumn(name = "Captured_Vital_Id", nullable = false)
	public SortedSet<VitalParamValue> getVitalParamValues() {
		return vitalParamValues;
	}

	public void setVitalParamValues(SortedSet<VitalParamValue> vitalParamValues) {
		this.vitalParamValues = vitalParamValues;
	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Tenant_Id", referencedColumnName = "Id")
//	@JSON(include = false)
//	@JsonIgnore
//	public Tenant getTenant()
//	{
//		return tenant;
//	}
//
//	public void setTenant(Tenant tenant)
//	{
//		this.tenant = tenant;
//	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id")
	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id")
	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean hasId()
	{
		return id != null && id > 0;
	}

	@Column(name = "Created_on", nullable = false)
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}