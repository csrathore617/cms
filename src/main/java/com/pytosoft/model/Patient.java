package com.pytosoft.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Patient 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	@NotBlank(message = "{patient.firstName.notBlank}")
	@Size(max = 30, message = "{patient.firstName.size}")
	//@Alpha(message = "{patient.firstName.regex}")
	private String firstName;

	@NotBlank(message = "{patient.lastName.notBlank}")
	@Size(max = 30, message = "{patient.lastName.size}")
	//@Alpha(message = "{patient.lastName.regex}")
	private String lastName;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{patient.email.email}")
	private String email;

	@NotBlank(message = "{patient.mobile.notBlank}")
	@Size(max = 10, min = 10, message = "{patient.mobile.size}")
	@Pattern(regexp = "[0-9]+", message = "{patient.mobile.regex}")
	private String mobile;

	// @NotBlank(message = "{patient.sex.notBlank}")
	@Size(max = 25, message = "{patient.sex.size}")
	//@Alpha(message = "{patient.sex.regex}")
	private String sex;


	@Size(max = 10, min = 10, message = "{patient.homePhone.size}")
	@Pattern(regexp = "[0-9]+", message = "{patient.homePhone.regex}")
	private String homePhone;

	@Size(max = 25, message = "{patient.bloodGroup.size}")
	private String bloodGroup;


	@Size(max = 25, message = "{patient.saluation.size}")
	//@Alpha(message = "{patient.saluation.regex}")
	private String saluation;

	@Size(max = 30, message = "{patient.middleName.size}")
	//@Alpha(message = "{patient.middleName.regex}")
	private String middleName;

	@Size(max = 20, message = "{patient.uniqueId.size}")
	private String uniqueId;

	@Size(max = 50, message = "{patient.maritalStatus.size}")
	//@Alpha(message = "{patient.maritalStatus.regex}")
	private String maritalStatus;

	@Size(max = 10, min = 10, message = "{patient.otherContactNumber.size}")
	@Pattern(regexp = "[0-9]+", message = "{patient.otherContactNumber.regex}")
	private String otherContactNumber;

	@Size(max = 255, message = "{patient.profilePicPath.size}")
	private String profilePicPath;
	private String profilePicName;

	@Size(max = 255, message = "{patient.interest.size}")
	//@NotHtml(message = "{patient.interest.notHtml}")
	private String interest;

	@Size(max = 100, message = "{patient.languages.size}")
	//@NotHtml(message = "{patient.languages.notHtml}")
	private String languages;

	@Size(max = 255, message = "{patient.notes.size}")
	//@NotHtml(message = "{patient.notes.notHtml}")
	private String notes;

	@Pattern(regexp = "[0-9]+", message = "{patient.age.regex}")
	private String age;

	@DecimalMax(value = "240", message = "{patient.height.max}")
	@DecimalMin(value = "30", message = "{patient.height.min}")
	private Float height;

	@DecimalMax(value = "200", message = "{patient.weight.max}")
	@DecimalMin(value = "2", message = "{patient.weight.min}")
	private Float weight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getSaluation() {
		return saluation;
	}

	public void setSaluation(String saluation) {
		this.saluation = saluation;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOtherContactNumber() {
		return otherContactNumber;
	}

	public void setOtherContactNumber(String otherContactNumber) {
		this.otherContactNumber = otherContactNumber;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	public String getProfilePicName() {
		return profilePicName;
	}

	public void setProfilePicName(String profilePicName) {
		this.profilePicName = profilePicName;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}

	public Patient(Long id, String firstName, String lastName, String email, String mobile, String sex,
			String homePhone, String bloodGroup, String saluation, String middleName, String uniqueId,
			String maritalStatus, String otherContactNumber, String profilePicPath, String profilePicName,
			String interest, String languages, String notes, String age, Float height, Float weight) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.sex = sex;
		this.homePhone = homePhone;
		this.bloodGroup = bloodGroup;
		this.saluation = saluation;
		this.middleName = middleName;
		this.uniqueId = uniqueId;
		this.maritalStatus = maritalStatus;
		this.otherContactNumber = otherContactNumber;
		this.profilePicPath = profilePicPath;
		this.profilePicName = profilePicName;
		this.interest = interest;
		this.languages = languages;
		this.notes = notes;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", sex=" + sex + ", homePhone=" + homePhone + ", bloodGroup=" + bloodGroup
				+ ", saluation=" + saluation + ", middleName=" + middleName + ", uniqueId=" + uniqueId
				+ ", maritalStatus=" + maritalStatus + ", otherContactNumber=" + otherContactNumber
				+ ", profilePicPath=" + profilePicPath + ", profilePicName=" + profilePicName + ", interest=" + interest
				+ ", languages=" + languages + ", notes=" + notes + ", age=" + age + ", height=" + height + ", weight="
				+ weight + "]";
	}
	
}
