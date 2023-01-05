package com.pytosoft.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constraint.Alpha;
import com.pytosoft.constraint.NotHtml;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.LabTestHistory;
import com.pytosoft.model.lab.LabOrder;
import com.pytosoft.model.procedure.CapturedVital;
import com.pytosoft.util.JsonDateDeserializer;

import flexjson.JSON;

public class PatientVO implements Serializable
{

	private static final long serialVersionUID = 1383488417237852984L;

	private Long id;

	@NotBlank(message = "{patient.firstName.notBlank}")
	@Size(max = 30, message = "{patient.firstName.size}")
	@Alpha(message = "{patient.firstName.regex}")
	private String firstName;

	@NotBlank(message = "{patient.lastName.notBlank}")
	@Size(max = 30, message = "{patient.lastName.size}")
	@Alpha(message = "{patient.lastName.regex}")
	private String lastName;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{patient.email.email}")
	private String email;

	@NotBlank(message = "{patient.mobile.notBlank}")
	@Size(max = 10, min = 10, message = "{patient.mobile.size}")
	@Pattern(regexp = "[0-9]+", message = "{patient.mobile.regex}")
	private String mobile;

	// @NotBlank(message = "{patient.sex.notBlank}")
	@Size(max = 25, message = "{patient.sex.size}")
	@Alpha(message = "{patient.sex.regex}")
	private String sex;

	@NotNull(message = "{patient.dateOfBirth.notNull}")
	@Past(message = "{patient.dateOfBirth.past}")
	private Date dateOfBirth;

	@NotNull(message = "{patient.since.notNull}")
	@Past(message = "{patient.since.past}")
	private Date since;

	@Size(max = 10, min = 10, message = "{patient.homePhone.size}")
	@Pattern(regexp = "[0-9]+", message = "{patient.homePhone.regex}")
	private String homePhone;

	@Size(max = 25, message = "{patient.bloodGroup.size}")
	private String bloodGroup;

	// @NotNull(message = "{patient.address.notNull}")
	@Valid
	private AddressVO address;

	@Size(max = 25, message = "{patient.saluation.size}")
	@Alpha(message = "{patient.saluation.regex}")
	private String saluation;

	@Size(max = 30, message = "{patient.middleName.size}")
	@Alpha(message = "{patient.middleName.regex}")
	private String middleName;

	@Size(max = 20, message = "{patient.uniqueId.size}")
	private String uniqueId;

	@Size(max = 50, message = "{patient.maritalStatus.size}")
	@Alpha(message = "{patient.maritalStatus.regex}")
	private String maritalStatus;

	@Size(max = 10, min = 10, message = "{patient.otherContactNumber.size}")
	@Pattern(regexp = "[0-9]+", message = "{patient.otherContactNumber.regex}")
	private String otherContactNumber;

	@Size(max = 255, message = "{patient.profilePicPath.size}")
	private String profilePicPath;
	private String profilePicName;

	@Size(max = 255, message = "{patient.interest.size}")
	@NotHtml(message = "{patient.interest.notHtml}")
	private String interest;

	@Size(max = 100, message = "{patient.languages.size}")
	@NotHtml(message = "{patient.languages.notHtml}")
	private String languages;

	@Size(max = 255, message = "{patient.notes.size}")
	@NotHtml(message = "{patient.notes.notHtml}")
	private String notes;

	@Pattern(regexp = "[0-9]+", message = "{patient.age.regex}")
	private String age;

	@DecimalMax(value = "240", message = "{patient.height.max}")
	@DecimalMin(value = "30", message = "{patient.height.min}")
	private Float height;

	@DecimalMax(value = "200", message = "{patient.weight.max}")
	@DecimalMin(value = "2", message = "{patient.weight.min}")
	private Float weight;

	@Valid
	private Doctor referredBy;

	@Size(max = 100, message = "{patient.referedByName.size}")
	@Alpha(message = "{patient.referedByName.regex}")
	private String referredByName;
	
	@Size(max = 500, message = "{patient.occupation.size}")
	@NotHtml(message = "{patient.occupation.notHtml}")
	private String occupation;

//	@Valid
//	private List<AllergyHistory> allergies;

//	@Valid
//	private List<SurgicalHistory> surgicalHistories;

//	@Valid
//	private List<ImmunizationHistory> immunizationHistories;

//	@Valid
//	private List<DiseaseHistory> diseaseHistories;

//	@Valid
//	private List<Medication> currentMedications;

	@Valid
	private List<MedicalCaseVO> medicalCases;

//	@Valid
//	private List<EmergencyContact> emergencyContacts;

//	@Valid
//	private List<FamilyHistory> familyHistories;

	@Valid
	private List<LabTestHistory> labTestHistories;
	
	private Date lastVisitDate ;
	
	private List<LabOrder> labOrders;
	
//	private Set<CapturedLifeStyle> capturedLifeStyles;
	
	private Set<CapturedVital> capturedVitals;

	public PatientVO()
	{
		this(null);
	}

	public PatientVO(Long id)
	{
		this.id = id;
	}

	public PatientVO(Long id, String firstName, String lastName)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public PatientVO(Long id, String firstName, String lastName, String mobile)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getHomePhone()
	{
		return homePhone;
	}

	public void setHomePhone(String homePhone)
	{
		this.homePhone = homePhone;
	}

	public String getBloodGroup()
	{
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup)
	{
		this.bloodGroup = bloodGroup;
	}

	public AddressVO getAddress()
	{
		return address;
	}

	public void setAddress(AddressVO address)
	{
		this.address = address;
	}

	/*
	 * @JSON(include = false) public List<AllergyHistory> getAllergies() { return
	 * allergies; }
	 * 
	 * public void setAllergies(List<AllergyHistory> allergies) { this.allergies =
	 * allergies; }
	 * 
	 * @JSON(include = false) public List<SurgicalHistory> getSurgicalHistories() {
	 * return surgicalHistories; }
	 * 
	 * public void setSurgicalHistories(List<SurgicalHistory> surgicalHistories) {
	 * this.surgicalHistories = surgicalHistories; }
	 * 
	 * @JSON(include = false) public List<ImmunizationHistory>
	 * getImmunizationHistories() { return immunizationHistories; }
	 * 
	 * public void setImmunizationHistories(List<ImmunizationHistory>
	 * immunizationHistories) { this.immunizationHistories = immunizationHistories;
	 * }
	 * 
	 * @JSON(include = false) public List<DiseaseHistory> getDiseaseHistories() {
	 * return diseaseHistories; }
	 * 
	 * public void setDiseaseHistories(List<DiseaseHistory> diseaseHistories) {
	 * this.diseaseHistories = diseaseHistories; }
	 * 
	 * @JSON(include = false) public List<Medication> getCurrentMedications() {
	 * return currentMedications; }
	 * 
	 * public void setCurrentMedications(List<Medication> currentMedications) {
	 * this.currentMedications = currentMedications; }
	 */
	@JSON(include = false)
	public List<MedicalCaseVO> getMedicalCases()
	{
		return medicalCases;
	}

	public void setMedicalCases(List<MedicalCaseVO> medicalCases)
	{
		this.medicalCases = medicalCases;
	}

	public String getSaluation()
	{
		return saluation;
	}

	public void setSaluation(String saluation)
	{
		this.saluation = saluation;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getUniqueId()
	{
		return uniqueId;
	}

	public void setUniqueId(String uniqueId)
	{
		this.uniqueId = uniqueId;
	}

	public String getMaritalStatus()
	{
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus)
	{
		this.maritalStatus = maritalStatus;
	}

	public String getOtherContactNumber()
	{
		return otherContactNumber;
	}

	public void setOtherContactNumber(String otherContactNumber)
	{
		this.otherContactNumber = otherContactNumber;
	}

	public String getProfilePicPath()
	{
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath)
	{
		this.profilePicPath = profilePicPath;
	}

	public String getProfilePicName()
	{
		return profilePicName;
	}

	public void setProfilePicName(String profilePicName)
	{
		this.profilePicName = profilePicName;
	}

	/*
	 * @JSON(include = false) public List<EmergencyContact> getEmergencyContacts() {
	 * return emergencyContacts; }
	 * 
	 * public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
	 * this.emergencyContacts = emergencyContacts; }
	 * 
	 * @JSON(include = false) public List<FamilyHistory> getFamilyHistories() {
	 * return familyHistories; }
	 * 
	 * public void setFamilyHistories(List<FamilyHistory> familyHistories) {
	 * this.familyHistories = familyHistories; }
	 */

	@JSON(include = false)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public String getInterest()
	{
		return interest;
	}

	public void setInterest(String interest)
	{
		this.interest = interest;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getLanguages()
	{
		return languages;
	}

	public void setLanguages(String languages)
	{
		this.languages = languages;
	}

	@JSON(include = false)
	public List<LabTestHistory> getLabTestHistories()
	{
		return labTestHistories;
	}

	public void setLabTestHistories(List<LabTestHistory> labTestHistories)
	{
		this.labTestHistories = labTestHistories;
	}

	public Float getHeight()
	{
		return height;
	}

	public void setHeight(Float height)
	{
		this.height = height;
	}

	public Float getWeight()
	{
		return weight;
	}

	public void setWeight(Float weight)
	{
		this.weight = weight;
	}

	@JSON(include = false)
	public Date getSince()
	{
		return since;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setSince(Date since)
	{
		this.since = since;
	}

	public Doctor getReferredBy()
	{
		return referredBy;
	}

	public void setReferredBy(Doctor referredBy)
	{
		this.referredBy = referredBy;
	}

	public String getReferredByName()
	{
		return referredByName;
	}

	public void setReferredByName(String referredByName)
	{
		this.referredByName = referredByName;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public List<LabOrder> getLabOrders() {
		return labOrders;
	}

	public void setLabOrders(List<LabOrder> labOrders) {
		this.labOrders = labOrders;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/*
	 * public Set<CapturedLifeStyle> getCapturedLifeStyles() { return
	 * capturedLifeStyles; }
	 * 
	 * public void setCapturedLifeStyles(Set<CapturedLifeStyle> capturedLifeStyles)
	 * { this.capturedLifeStyles = capturedLifeStyles; }
	 */

	public Set<CapturedVital> getCapturedVitals() {
		return capturedVitals;
	}

	public void setCapturedVitals(Set<CapturedVital> capturedVitals) {
		this.capturedVitals = capturedVitals;
	}
}

