package com.pytosoft.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.constants.BookingSchedule;
import com.pytosoft.constraint.Alpha;
import com.pytosoft.model.Address;
import com.pytosoft.model.DegreePassed;
import com.pytosoft.model.DoctorSpecialization;
import com.pytosoft.model.Experience;
import com.pytosoft.model.Expertise;
import com.pytosoft.util.JsonDateDeserializer;
import com.pytosoft.constraint.*;

import flexjson.JSON;


public class DoctorVO implements Serializable
{
	private static final long serialVersionUID = 356005324430038052L;

	@NotNull(groups = { BookingSchedule.class }, message = "{doctor.id.notNull}")
	@Min(groups = { BookingSchedule.class }, value = 1, message = "{doctor.id.min}")
	private Long id;

	@NotBlank(message = "{doctor.firstName.notBlank}")
	@Size(max = 30, message = "{doctor.firstName.size}")
	@Alpha(message = "{doctor.firstName.regex}")
	private String firstName;

	@NotBlank(message = "{doctor.lastName.notBlank}")
	@Size(max = 30, message = "{doctor.lastName.size}")
	@Alpha(message = "{doctor.lastName.regex}")
	private String lastName;

	@NotBlank(message = "{doctor.sex.notBlank}")
	@Size(max = 10, message = "{doctor.sex.size}")
	@Alpha(message = "{doctor.sex.regex}")
	private String sex;

	@NotNull(message = "{doctor.address.notNull}")
	@Valid
	private Address address;

	@Size(max = 10, min = 10, message = "{doctor.homePhone.size}")
	@Pattern(regexp = "[0-9]+", message = "{doctor.homePhone.regex}")
	private String homePhone;

	@NotBlank(message = "{doctor.mobile.notBlank}")
	@Size(max = 10, min = 10, message = "{doctor.mobile.size}")
	@Pattern(regexp = "[0-9]+", message = "{doctor.mobile.regex}")
	private String mobile;

	@NotBlank(message = "{doctor.email.notBlank}")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{doctor.email.email}")
	private String email;

	private String profilePicPath;

	private String profilePicName;

	@URL(message = "{doctor.website.url}")
	private String website;

	@Past(message = "{doctor.practiceStartDate.past}")
	private Date practiceStartDate;

	@Size(max = 255, message = "{doctor.interest.size}")
	@AlphaNumeric(message = "{doctor.interest.alphaNumeric}")
	private String interest;

	@Size(max = 100, message = "{doctor.languages.size}")
	@Alpha(message = "{doctor.languages.regex}")
	private String languages;

	@Size(max = 30, message = "{doctor.middleName.size}")
	@Alpha(message = "{doctor.middleName.regex}")
	private String middleName;

	@Size(max = 25, message = "{doctor.saluation.size}")
	@Alpha(message = "{doctor.saluation.regex}")
	private String saluation;

	@Size(max = 20, message = "{doctor.uniqueId.size}")
	private String uniqueId;

	@Size(max = 50, message = "{doctor.maritalStatus.size}")
	@Alpha(message = "{doctor.maritalStatus.regex}")
	private String maritalStatus;

	@Size(max = 10, min = 10, message = "{doctor.otherContactNumber.size}")
	@Pattern(regexp = "[0-9]+", message = "{doctor.otherContactNumber.regex}")
	private String otherContactNumber;

	// private String profilePicPath;

	@Past(message = "{patient.dateOfBirth.past}")
	private Date dateOfBirth;

	private boolean acceptsNewPatient;

	private boolean availableForHomeVisit;

	// only for ui purpose
	private List<ClinicVO> assignedClinics;

	// newly added
	@NotEmpty(message = "{doctor.degreesPassed.notEmpty}")
	@Valid
	private Set<DegreePassed> degreesPassed;

	@NotEmpty(message = "{doctor.doctorSpecializations.notEmpty}")
	@Valid
	private Set<DoctorSpecialization> doctorSpecializations;

	@Valid
	private Set<Expertise> expertises;

	@Valid
	private Set<Experience> experiences;

	// For PatientApp
	private ClinicVO primaryClinic;

	// For PatientApp
	private Map<String, List<DoctorTimingByClinicVO>> timingMap;

	private BigDecimal rating;
	
	public DoctorVO()
	{

	}

	public DoctorVO(Long id)
	{
		super();
		this.id = id;
	}

	public DoctorVO(Long id, String firstName, String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@JSON(include = false)
	public Set<Experience> getExperiences()
	{
		return experiences;
	}

	public void setExperiences(Set<Experience> experiences)
	{
		this.experiences = experiences;
	}

	@JSON(include = false)
	public boolean getAcceptsNewPatient()
	{
		return acceptsNewPatient;
	}

	public void setAcceptsNewPatient(boolean acceptsNewPatient)
	{
		this.acceptsNewPatient = acceptsNewPatient;
	}

	@JSON(include = false)
	public boolean getAvailableForHomeVisit()
	{
		return availableForHomeVisit;
	}

	public void setAvailableForHomeVisit(boolean b)
	{
		this.availableForHomeVisit = b;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getSaluation()
	{
		return saluation;
	}

	public void setSaluation(String saluation)
	{
		this.saluation = saluation;
	}

	@JSON(include = false)
	public String getUniqueId()
	{
		return uniqueId;
	}

	public void setUniqueId(String uniqueId)
	{
		this.uniqueId = uniqueId;
	}

	@JSON(include = false)
	public String getMaritalStatus()
	{
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus)
	{
		this.maritalStatus = maritalStatus;
	}

	@JSON(include = false)
	public String getOtherContactNumber()
	{
		return otherContactNumber;
	}

	public void setOtherContactNumber(String otherContactNumber)
	{
		this.otherContactNumber = otherContactNumber;
	}

	@JSON(include = false)
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
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

	@JSON(include = false)
	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	@JSON(include = false)
	public String getHomePhone()
	{
		return homePhone;
	}

	public void setHomePhone(String homePhone)
	{
		this.homePhone = homePhone;
	}

	@JSON(include = false)
	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	@JSON(include = false)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getProfilePicPath()
	{
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath)
	{
		this.profilePicPath = profilePicPath;
	}

	@JSON(include = false)
	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	@JSON(include = false)
	public Date getPracticeStartDate()
	{
		return practiceStartDate;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setPracticeStartDate(Date practiceStartDate)
	{
		this.practiceStartDate = practiceStartDate;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@JSON(include = false)
	public Set<DegreePassed> getDegreesPassed()
	{
		return degreesPassed;
	}

	public void setDegreesPassed(Set<DegreePassed> degreesPassed)
	{
		this.degreesPassed = degreesPassed;
	}

	@JSON(include = false)
	public Set<DoctorSpecialization> getDoctorSpecializations()
	{
		return doctorSpecializations;
	}

	public void setDoctorSpecializations(Set<DoctorSpecialization> doctorSpecializations)
	{
		this.doctorSpecializations = doctorSpecializations;
	}

	@JSON(include = false)
	public Set<Expertise> getExpertises()
	{
		return expertises;
	}

	public void setExpertises(Set<Expertise> expertises)
	{
		this.expertises = expertises;
	}

	@JSON(include = false)
	public List<ClinicVO> getAssignedClinics()
	{
		return assignedClinics;
	}

	public void setAssignedClinics(List<ClinicVO> assignedClinics)
	{
		this.assignedClinics = assignedClinics;
	}

	@JSON(include = false)
	public String getInterest()
	{
		return interest;
	}

	public void setInterest(String interest)
	{
		this.interest = interest;
	}

	@JSON(include = false)
	public String getLanguages()
	{
		return languages;
	}

	public void setLanguages(String languages)
	{
		this.languages = languages;
	}

	public String getProfilePicName()
	{
		return profilePicName;
	}

	public void setProfilePicName(String profilePicName)
	{
		this.profilePicName = profilePicName;
	}

	public ClinicVO getPrimaryClinic()
	{
		return primaryClinic;
	}

	public void setPrimaryClinic(ClinicVO primaryClinic)
	{
		this.primaryClinic = primaryClinic;
	}

	public Map<String, List<DoctorTimingByClinicVO>> getTimingMap()
	{
		return timingMap;
	}

	public void setTimingMap(Map<String, List<DoctorTimingByClinicVO>> timingMap)
	{
		this.timingMap = timingMap;
	}

	public BigDecimal getRating() {
		return rating;
	}
	

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	
	
	
}
