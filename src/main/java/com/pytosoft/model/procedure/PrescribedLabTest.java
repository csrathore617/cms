package com.pytosoft.model.procedure;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cglib.core.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.pytosoft.constraint.CreateEntity;
import com.pytosoft.model.Diagnosis;
import com.pytosoft.model.Visit;
import com.pytosoft.model.v3.LabTestReferral;

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
import jakarta.persistence.Transient;

@Entity
@Table(name = "prescribed_lab_test")
public class PrescribedLabTest 


{
	private static final long serialVersionUID = 6931783740387415825L;

	public static final String VISIT = "visit";

	public static final String PRESCRIPTION_DATE = "prescriptionDate";

	public static final String ID = "id";

	public static final String TENANT_PRESCRIBED_LAB_TEST_MAPPINGS = "tenantPrescribedLabTestMappings";
	
	public static final String DIAGNOSIS = "diagnosis";

	public static final String ORDERING = "ordering";

	public static final String LAB_TEST_REFERRAL_ITEMS = "labTestReferralItems";

	public static final String PROCEDURE = "procedure";

	@NotNull(groups = { CreateEntity.class }, message = "{prescribedLabTest.id.notNull}")
	@Min(groups = { CreateEntity.class }, value = 1, message = "{prescribedLabTest.id.min}")
	private Long id;

	private Date prescriptionDate;

	private Set<LabTestReferral> labTestReferrals;
	
//	private Set<InvestigationAttachment> attachments;

//	@NotNull(groups = { UpdateEntity.class, Default.class }, message = "{prescribedDiagnosis.diagnosis.notNull}")
//	@Valid
	private Diagnosis diagnosis;

//	@Size(groups = { UpdateEntity.class }, max = 255, message = "{prescribedDiagnosis.notes.size}")
//	@NotHtml(groups = { UpdateEntity.class }, message = "{prescribedDiagnosis.notes.notHtml}")
	private String notes;

//	private Visit visit;
	
	private Procedure procedure;
	
	private Integer ordering;

//	private Set<TenantPrescribedLabTestMapping> tenantPrescribedLabTestMappings;
	
//	private List<LabTestReferralItem> labTestReferralItems;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Diagnosis_Id", referencedColumnName = "Id")
	
	public Diagnosis getDiagnosis()
	{
		return diagnosis;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setDiagnosis(Diagnosis diagnosis)
	{
		this.diagnosis = diagnosis;
	}

	@Column(name = "Notes", nullable = true, length = 255)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

//	@ManyToOne(optional = true)
//	@JoinColumn(name = "Visit_Id", referencedColumnName = "Id")
	
//	public /*Visit */getVisit()
//	{
//		return visit;
//	}
//
////	public void setVisit(/*Visit */visit)
//	{
//		this.visit = visit;
//	}

	@ManyToOne(optional = true,cascade = CascadeType.ALL)
	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id")
	
	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	@Column(name = "PrescriptionDate", nullable = false)
	public Date getPrescriptionDate()
	{
		return prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate)
	{
		this.prescriptionDate = prescriptionDate;
	}

	@Transient
	
	public Set<LabTestReferral> getLabTestReferrals()
	{
		return labTestReferrals;
	}

	public void setLabTestReferrals(Set<LabTestReferral> labTestReferrals)
	{
		this.labTestReferrals = labTestReferrals;
	}
	
	/*
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "prescribedLabTest") public Set<InvestigationAttachment> getAttachments() {
	 * return attachments; }
	 * 
	 * public void setAttachments(Set<InvestigationAttachment> attachments) {
	 * this.attachments = attachments; }
	 */

	@Column(name = "Ordering", nullable = true)
	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
	/*
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "prescribedLabTest")
	 * 
	 * 
	 * 
	 * @JsonIgnore public Set<TenantPrescribedLabTestMapping>
	 * getTenantPrescribedLabTestMappings() { return
	 * tenantPrescribedLabTestMappings; }
	 * 
	 * public void
	 * setTenantPrescribedLabTestMappings(Set<TenantPrescribedLabTestMapping>
	 * tenantPrescribedLabTestMappings) { this.tenantPrescribedLabTestMappings =
	 * tenantPrescribedLabTestMappings; }
	 */
	
	/*
	 * @OneToMany(mappedBy = LabTestReferralItem.PRESCRIBED_LAB_TEST)
	 * 
	 * @Fetch(FetchMode.SELECT)
	 * 
	 * @BatchSize(size=25) public List<LabTestReferralItem>
	 * getLabTestReferralItems() { return labTestReferralItems; }
	 * 
	 * public void setLabTestReferralItems(List<LabTestReferralItem>
	 * labTestReferralItems) { this.labTestReferralItems = labTestReferralItems; }
	 * 
	 * 
	 * public void mapTenant(Tenant tenant) { if (this.id == null) // map only while
	 * creating { if (this.tenantPrescribedLabTestMappings == null) {
	 * this.tenantPrescribedLabTestMappings = new
	 * LinkedHashSet<TenantPrescribedLabTestMapping>(); }
	 * this.tenantPrescribedLabTestMappings.add(new
	 * TenantPrescribedLabTestMapping(tenant, this)); } }
	 */

	/*
	 * public void prepareLabTestReferrals() { if
	 * (CollectionUtils.isEmpty(labTestReferralItems)) { this.labTestReferrals =
	 * Collections.emptySet(); } else { Set<LabTestReferral> temp = new
	 * LinkedHashSet<LabTestReferral>(); for (LabTestReferralItem
	 * labTestReferralItem : labTestReferralItems) { LabTestReferral labTestReferral
	 * = labTestReferralItem.getLabTestReferral(); labTestReferral.getNotes();
	 * labTestReferral.setLabTestReferralItems(null);
	 * labTestReferral.setReferedBy(null); labTestReferral.setReferedTo(new
	 * Lab(labTestReferral.getReferedTo().getId(),
	 * labTestReferral.getReferedTo().getName())); temp.add(labTestReferral); }
	 * this.labTestReferrals = temp; } }
	 */

}

