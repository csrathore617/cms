package com.pytosoft.model.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.cglib.core.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pytosoft.constants.PrescriptionStatus;
import com.pytosoft.constraint.CreateEntity;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.lab.Lab;
import com.pytosoft.model.procedure.PrescribedLabTest;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "lab_test_referral")
@BatchSize(size = 20)
public class LabTestReferral

{

	private static final long serialVersionUID = -1688720097554713933L;

	public static final String REFERED_TO = "referedTo";

	public static final String REFERED_BY = "referedBy";

	public static final String FULL_FILLED = "fullfilled";

	public static final String REFERED_ON = "referedOn";

	public static final String ID = "id";

	public static final String DETAIL_TYPE_WITH_LABREPORT = "withLabReport";

	public static final String PRESCRIPTION_STATUS = "prescriptionStatus";

	public static final String TENANT_LAB_TEST_REFERRALS = "tenantLabTestReferrals";

	public static final String LAB_TEST_REFERRAL_ITEMS = "labTestReferralItems";

	private Long id;

	private Date referedOn;

	@ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "Refered_By", referencedColumnName = "id")
	private Doctor referedBy;

	@NotNull(groups = { CreateEntity.class }, message = "{referedDiagnosisPrescription.referedTo.notNull}")
	@Valid
	private Lab referedTo;

	private boolean fullfilled;

	private PrescriptionStatus prescriptionStatus;

//	@NotBlank(groups = { UpdateEntity.class }, message = "{prescribedDiagnosis.result.notBlank}")
//	@Size(groups = { UpdateEntity.class }, max = 50, message = "{prescribedDiagnosis.result.size}")
	private String result;

//	@Size(groups = { UpdateEntity.class }, max = 255, message = "{prescribedDiagnosis.notes.size}")
//	@NotHtml(groups = { UpdateEntity.class }, message = "{prescribedDiagnosis.notes.notHtml}")
	private String notes;

//	private Set<TenantLabTestReferralMapping> tenantLabTestReferrals;

//	@NotEmpty(groups = { CreateEntity.class }, message = "{referedDiagnosisPrescription.diagnosisPrescription.notNull}")
//	private List<LabTestReferralItem> labTestReferralItems;

	public LabTestReferral() {
	}

	public LabTestReferral(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId() {
		return id;
	}

	@Column(name = "Refered_On", nullable = false)
	public Date getReferedOn() {
		return referedOn;
	}

	
//	public Doctor getReferedBy() {
//		return referedBy;
//	}
//	public void setReferedBy(Doctor referedBy) {
//		this.referedBy = referedBy;
//	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "Refered_To", referencedColumnName = "Id")
	@Fetch(FetchMode.SELECT)
	public Lab getReferedTo() {
		return referedTo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setReferedOn(Date referedOn) {
		this.referedOn = referedOn;
	}


	public void setReferedTo(Lab referedTo) {
		this.referedTo = referedTo;
	}

	@Column(name = "Full_Filled", nullable = true)
	public boolean isFullfilled() {
		return fullfilled;
	}

	public void setFullfilled(boolean fullfilled) {
		this.fullfilled = fullfilled;
	}

	@Column(name = "Prescription_Status", nullable = true)
	@Enumerated(EnumType.STRING)
	public PrescriptionStatus getPrescriptionStatus() {
		return prescriptionStatus;
	}

	public void setPrescriptionStatus(PrescriptionStatus prescriptionStatus) {
		this.prescriptionStatus = prescriptionStatus;
	}

	@Column(name = "Result", nullable = true, length = 50)
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "Notes", nullable = true, length = 255)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "labTestReferral")
	 * 
	 * @JSON(include = false)
	 * 
	 * @JsonIgnore public Set<TenantLabTestReferralMapping>
	 * getTenantLabTestReferrals() { return tenantLabTestReferrals; }
	 * 
	 * public void setTenantLabTestReferrals(Set<TenantLabTestReferralMapping>
	 * tenantLabTestReferrals) { this.tenantLabTestReferrals =
	 * tenantLabTestReferrals; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "labTestReferral") public List<LabTestReferralItem> getLabTestReferralItems()
	 * { return labTestReferralItems; }
	 * 
	 * public void setLabTestReferralItems(List<LabTestReferralItem>
	 * labTestReferralItems) { this.labTestReferralItems = labTestReferralItems; }
	 * 
	 * @Override public void mapTenant(Tenant tenant) { if
	 * (this.tenantLabTestReferrals == null) { this.tenantLabTestReferrals = new
	 * LinkedHashSet<TenantLabTestReferralMapping>(); }
	 * this.tenantLabTestReferrals.add(new TenantLabTestReferralMapping(tenant,
	 * this)); } public void preSave(Tenant tenant, Doctor doctor) {
	 * mapTenant(tenant); setPrescriptionStatus(PrescriptionStatus.REFERRED);
	 * setFullfilled(false); setReferedOn(new Date()); setReferedBy(doctor); for
	 * (LabTestReferralItem current : labTestReferralItems) {
	 * current.setLabTestReferral(this); } }
	 */

	public boolean hasId() {
		return id != null && id > 0;
	}

	/*
	 * @Transient
	 * 
	 * @JsonIgnore public List<PrescribedLabTest> findPrescribedLabTests() {
	 * List<PrescribedLabTest> prescribedLabTests; // if
	 * (CollectionUtils.isEmpty(labTestReferralItems)) { prescribedLabTests =
	 * Collections.emptyList(); } else { prescribedLabTests = new
	 * ArrayList<PrescribedLabTest>();
	 * 
	 * for (LabTestReferralItem labTestReferralItem : labTestReferralItems) {
	 * prescribedLabTests.add(labTestReferralItem.getPrescribedLabTest()); }
	 * 
	 * } return prescribedLabTests; }
	 */
}