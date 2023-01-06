package com.pytosoft.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;

import com.pytosoft.constants.BloodGroup;
import com.pytosoft.model.procedure.CapturedVital;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
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
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
@DiscriminatorValue("PATIENT")
@PrimaryKeyJoinColumn(name = "Id", referencedColumnName = "Id")

public class Patient {

	public static final String FP_PATIENT_MED_INFO = "patient_fetch_profile";

	public static final String FP_PATIENT_MED_CASES = "patient_medical_case_fetch_profile";

	public static final String ALLERGIES = "allergies";

	public static final String ID = "id";

	public static final String IMMUNIZATIONS = "immunizations";

	public static final String SURGERIES = "surgeries";

	public static final String DISEASES = "diseases";

	public static final String MEDICATIONS = "medications";

	public static final String FAMILY_HISTORIES = "familyHistories";

	public static final String LAB_TEST_HISTORIES = "labTestHistories";

	public static final String LAST_ACTIVITY_DATE = "lastActivityDate";

	public static final String TENANT_PATIENT_MAPPINGS = "tenantPatientMappings";

	public static final String CAPTURED_LIFE_STYLES = "capturedLifeStyles";
	
	public static final String CAPTURED_VITALS = "capturedVitals";
	
	public static final String ACTIVE = "active";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date dateOfBirth;

	private BloodGroup bloodGroup;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<AllergyHistory> allergies;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<DiseaseHistory> diseases;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<SurgicalHistory> surgeries;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<ImmunizationHistory> immunizations;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<Medication> medications;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<MedicalCase> medicalCases;

	private String notes;

	private Float height;

	private Float weight;

	private Date lastActivityDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Referred_By", referencedColumnName = "Id")
	private Doctor referredBy;

	private String referredByName;
	
	private String occupation;
	
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<EmergencyContact> emergencyContacts;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private List<FamilyHistory> familyHistories;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private Set<CapturedLifeStyle> capturedLifeStyles;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
	private Set<CapturedVital> capturedVitals;

	public Patient()
	{

	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Value("true")
	@Column(name = "Active", nullable = false)
	public boolean getIsActive() {
		return active;
	}

	public void setIsActive(boolean active) {
		this.active = active;
	}

	
	@Column(name = "Date_Of_Birth", nullable = false)
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	@Column(name = "Blood_Group", length = 25, nullable = true)
	@Enumerated(EnumType.STRING)
	public BloodGroup getBloodGroup()
	{
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup)
	{
		this.bloodGroup = bloodGroup;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	
	public List<AllergyHistory> getAllergies()
	{
		return allergies;
	}

	public void setAllergies(List<AllergyHistory> allergies)
	{
		this.allergies = allergies;
	}

	public List<FamilyHistory> getFamilyHistories()
	{
		return familyHistories;
	}

	public void setFamilyHistories(List<FamilyHistory> familyHistories)
	{
		this.familyHistories = familyHistories;
	}

	
	public List<EmergencyContact> getEmergencyContacts()
	{
		return emergencyContacts;
	}

	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts)
	{
		this.emergencyContacts = emergencyContacts;
	}
	
	
	public List<DiseaseHistory> getDiseases()
	{
		return diseases;
	}

	public void setDiseases(List<DiseaseHistory> diseases)
	{
		this.diseases = diseases;
	}

	public List<SurgicalHistory> getSurgeries()
	{
		return surgeries;
	}

	public void setSurgeries(List<SurgicalHistory> surgeries)
	{
		this.surgeries = surgeries;
	}

	public List<ImmunizationHistory> getImmunizations()
	{
		return immunizations;
	}

	public void setImmunizations(List<ImmunizationHistory> immunizations)
	{
		this.immunizations = immunizations;
	}

	public List<Medication> getMedications()
	{
		return medications;
	}

	public void setMedications(List<Medication> medications)
	{
		this.medications = medications;
	}

	public List<MedicalCase> getMedicalCases()
	{
		return medicalCases;
	}

	public void setMedicalCases(List<MedicalCase> medicalCases)
	{
		this.medicalCases = medicalCases;
	}

	@Column(name = "notes", length = 255, nullable = true)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	@Column(name = "occupation", length = 500, nullable = true)
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "height")
	public Float getHeight()
	{
		return height;
	}

	public void setHeight(Float height)
	{
		this.height = height;
	}

	@Column(name = "weight")
	public Float getWeight()
	{
		return weight;
	}

	public void setWeight(Float weight)
	{
		this.weight = weight;
	}


	@Column(name = "Last_Activity_Date", nullable = false)
	public Date getLastActivityDate()
	{
		return lastActivityDate;
	}

	public void setLastActivityDate(Date lastActivityDate)
	{
		this.lastActivityDate = lastActivityDate;
	}

	
	
	public Doctor getReferredBy()
	{
		return referredBy;
	}

	public void setReferredBy(Doctor referredBy)
	{
		this.referredBy = referredBy;
	}

	@Column(name = "Referred_By_Name", length = 100, nullable = true)
	public String getReferredByName()
	{
		return referredByName;
	}

	public void setReferredByName(String referredByName)
	{
		this.referredByName = referredByName;
	}

	
	public Set<CapturedLifeStyle> getCapturedLifeStyles() {
		return capturedLifeStyles;
	}

	public void setCapturedLifeStyles(Set<CapturedLifeStyle> capturedLifeStyles) {
		this.capturedLifeStyles = capturedLifeStyles;
	}

		public Set<CapturedVital> getCapturedVitals() {
		return capturedVitals;
	}

	public void setCapturedVitals(Set<CapturedVital> capturedVitals) {
		this.capturedVitals = capturedVitals;
	}

	public void sortCapturedLifeStyle() {
		Comparator<CapturedLifeStyle> comparator = new Comparator<CapturedLifeStyle>() {
			public int compare(CapturedLifeStyle o1, CapturedLifeStyle o2) {
				if(o1.getLifeStyle().getOrdering() == null){
					return 0;
				}
				return o1.getLifeStyle().getOrdering().compareTo(o2.getLifeStyle().getOrdering());
			};
		};
		List<CapturedLifeStyle> tempList = new ArrayList<CapturedLifeStyle>(capturedLifeStyles);
		Collections.sort(tempList, comparator);

		Set<CapturedLifeStyle> temp = new LinkedHashSet<CapturedLifeStyle>(tempList);
		this.capturedLifeStyles.clear();
		this.capturedLifeStyles.addAll(temp);
	}
	
	public void sortCapturedVitals() {
		Comparator<CapturedVital> comparator = new Comparator<CapturedVital>() {
			public int compare(CapturedVital o1, CapturedVital o2) {
				if(o1.getCreatedOn() == null){
					return 0;
				}
				return o2.getCreatedOn().compareTo(o1.getCreatedOn());
			};
		};
		List<CapturedVital> tempList = new ArrayList<CapturedVital>(capturedVitals);
		Collections.sort(tempList, comparator);

		Set<CapturedVital> temp = new LinkedHashSet<CapturedVital>(tempList);
		this.capturedVitals.clear();
		this.capturedVitals.addAll(temp);
	}

}
