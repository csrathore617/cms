package com.pytosoft.vo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.pytosoft.model.AllergyHistory;
import com.pytosoft.model.DiseaseHistory;
import com.pytosoft.model.EmergencyContact;
import com.pytosoft.model.FamilyHistory;
import com.pytosoft.model.ImmunizationHistory;
import com.pytosoft.model.LabTestHistory;
import com.pytosoft.model.Medication;
import com.pytosoft.model.SurgicalHistory;
import com.pytosoft.model.procedure.VisitAttachment;

public class ReferralVO
{

	@NotNull(message = "{referral.id.notNull}")
	@Min(value = 1, message = "{referral.id.min}")
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

	private String sex;

	private Date dateOfBirth;

	private String homePhone;

	private String bloodGroup;

	private AddressVO address;

	private String saluation;

	private String middleName;

	private String uniqueId;

	private String maritalStatus;

	private String otherContactNumber;

	private String profilePicName;

	private String profilePicPath;

	private String interest;

	private String languages;

	private String notes;

	private String age;

	private Float height;

	private Float weight;

	private Date referredOn;

	private Long patientId;

	private Boolean addToMyPatient;

	private List<AllergyHistory> allergies;

	private List<SurgicalHistory> surgicalHistories;

	private List<ImmunizationHistory> immunizationHistories;

	private List<DiseaseHistory> diseaseHistories;

	private List<Medication> currentMedications;

	private List<MedicalCaseVO> medicalCases;

	private List<EmergencyContact> emergencyContacts;

	private List<FamilyHistory> familyHistories;

	private List<LabTestHistory> labTestHistories;

	private MedicalCaseVO medicalCase;

	private DoctorVO doctor;

	private PatientVO patient;

	private List<VisitVO> visits;

	private List<VisitAttachment> visitAttachments;

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

	public String getProfilePicName()
	{
		return profilePicName;
	}

	public void setProfilePicName(String profilePicName)
	{
		this.profilePicName = profilePicName;
	}

	public String getInterest()
	{
		return interest;
	}

	public void setInterest(String interest)
	{
		this.interest = interest;
	}

	public String getLanguages()
	{
		return languages;
	}

	public void setLanguages(String languages)
	{
		this.languages = languages;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
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

	public List<AllergyHistory> getAllergies()
	{
		return allergies;
	}

	public void setAllergies(List<AllergyHistory> allergies)
	{
		this.allergies = allergies;
	}

	public List<SurgicalHistory> getSurgicalHistories()
	{
		return surgicalHistories;
	}

	public void setSurgicalHistories(List<SurgicalHistory> surgicalHistories)
	{
		this.surgicalHistories = surgicalHistories;
	}

	public List<ImmunizationHistory> getImmunizationHistories()
	{
		return immunizationHistories;
	}

	public void setImmunizationHistories(List<ImmunizationHistory> immunizationHistories)
	{
		this.immunizationHistories = immunizationHistories;
	}

	public List<DiseaseHistory> getDiseaseHistories()
	{
		return diseaseHistories;
	}

	public void setDiseaseHistories(List<DiseaseHistory> diseaseHistories)
	{
		this.diseaseHistories = diseaseHistories;
	}

	public List<Medication> getCurrentMedications()
	{
		return currentMedications;
	}

	public void setCurrentMedications(List<Medication> currentMedications)
	{
		this.currentMedications = currentMedications;
	}

	public List<MedicalCaseVO> getMedicalCases()
	{
		return medicalCases;
	}

	public void setMedicalCases(List<MedicalCaseVO> medicalCases)
	{
		this.medicalCases = medicalCases;
	}

	public List<EmergencyContact> getEmergencyContacts()
	{
		return emergencyContacts;
	}

	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts)
	{
		this.emergencyContacts = emergencyContacts;
	}

	public List<FamilyHistory> getFamilyHistories()
	{
		return familyHistories;
	}

	public void setFamilyHistories(List<FamilyHistory> familyHistories)
	{
		this.familyHistories = familyHistories;
	}

	public List<LabTestHistory> getLabTestHistories()
	{
		return labTestHistories;
	}

	public void setLabTestHistories(List<LabTestHistory> labTestHistories)
	{
		this.labTestHistories = labTestHistories;
	}

	public MedicalCaseVO getMedicalCase()
	{
		return medicalCase;
	}

	public void setMedicalCase(MedicalCaseVO medicalCase)
	{
		this.medicalCase = medicalCase;
	}

	public Date getReferredOn()
	{
		return referredOn;
	}

	public void setReferredOn(Date referredOn)
	{
		this.referredOn = referredOn;
	}

	public DoctorVO getDoctor()
	{
		return doctor;
	}

	public void setDoctor(DoctorVO doctor)
	{
		this.doctor = doctor;
	}

	public PatientVO getPatient()
	{
		return patient;
	}

	public void setPatient(PatientVO patient)
	{
		this.patient = patient;
	}

	public List<VisitVO> getVisits()
	{
		return visits;
	}

	public void setVisits(List<VisitVO> visits)
	{
		this.visits = visits;
	}

	public List<VisitAttachment> getVisitAttachments()
	{
		return visitAttachments;
	}

	public void setVisitAttachments(List<VisitAttachment> visitAttachments)
	{
		this.visitAttachments = visitAttachments;
	}

	public Long getPatientId()
	{
		return patientId;
	}

	public void setPatientId(Long patientId)
	{
		this.patientId = patientId;
	}

	public Boolean getAddToMyPatient()
	{
		return addToMyPatient;
	}

	public void setAddToMyPatient(Boolean addToMyPatient)
	{
		this.addToMyPatient = addToMyPatient;
	}

	public String getProfilePicPath()
	{
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath)
	{
		this.profilePicPath = profilePicPath;
	}

}
