package com.pytosoft.model;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "hospital")
//@DiscriminatorValue("HOSPITALCLINIC")
//@PrimaryKeyJoinColumn(name = "Id", referencedColumnName = "Id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","FieldHandler"})
public class Hospital {

	private static final long serialVersionUID = -1537100357546871489L;

	public static final String NAME = "name";

	public static final String ADDRESS = "address";

	public static final String ID = "id";

	public static final String FP_HOSPITAL_ADDRESS = "fp_hospital_address";

	public static final String FP_HOSPITAL_SPEC = "fp_hospital_spec";

	public static final String FP_HOSPITAL_FEC = "fp_hospital_fec";

	public static final String FP_HOSPITAL_ALTERNATE_NUMBERS = "fp_hospital_alternate_numbers";

	public static final String FP_HOSPITAL_PAYMENT_MODES = "fp_hospital_payment_modes";

	public static final String FP_HOSPITAL_ASSIGNED_ADMINS = "fp_hospital_assigned_admins";

	public static final String ASSIGNED_ADMINS = "assignedAdmins";

//	@Valid
//	private List<HospitalAdmin> assignedAdmins;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hospitalId")
	private Integer hospitalId;

	@NotBlank(message = "{hospital.name.notBlank}")
	@Size(max = 100, min = 10, message = "{hospital.name.size}")
	// @NotHtml(message = "{hospital.name.notHtml}")
	private String name;

	// @Pattern(regexp =
	// "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
	// message = "{hospital.email.email}")
	private String email;

	// @Past(message = "{hospital.startedIn.past}")
	private Date startedIn;

	@NotNull(message = "{hospital.address.notNull}")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Address address;

	@NotBlank(message = "{hospital.phoneNumber.notBlank}")
	// @Size(max = 10, min = 10, message = "{hospital.phoneNumber.size}")
	// @Pattern(regexp = "[0-9]+", message = "{hospital.phoneNumber.regex}")
	private String phoneNumber;

//	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId")
	private Set<PaymentMode> acceptedPaymentModes;

	private boolean ambulanceService;

	@Size(max = 255, message = "{hospital.businessLogoPath.size}")
	private String businessLogoPath;

	@Size(max = 255, message = "{hospital.notes.size}")
	// @NotHtml(message = "{hospital.notes.notHtml}")
	private String notes;

	// @Size(max = 15, min = 10, message = "{hospital.fax1.size}")
	// @Pattern(regexp = "[0-9]+", message = "{hospital.fax1.regex}")
	private String fax1;

	// @Size(max = 15, min = 10, message = "{hospital.fax2.size}")
	// @Pattern(regexp = "[0-9]+", message = "{hospital.fax2.regex}")
	private String fax2;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId")
	private Set<HospitalSpecialization> hospitalSpecializations;

	//@Valid
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId"/* , nullable = false */)
	private Set<AvailableFacility> availableFacilities;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId")
	private Set<OperatingDaysHours> operatingDaysHours;

	@NotBlank(message = "{hospital.licenseNumber.notBlank}")
	@Size(max = 10, message = "{hospital.licenseNumber.size}")
	@Pattern(regexp = "^([0-9|a-z|A-Z|\\-|\\/\\|/S])+", message = "{hospital.licenseNumber.alphanumeric}")
	private String licenseNumber;

	private String yearOfEstablishment;

	private String numberOfBeds;

	private String hospitalType;

	@Value("true")
	private boolean isActive;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId")
	private Set<AlternateNumber> alternateNumbers;

	public Hospital() {

	}


		
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "Hospital_id", referencedColumnName = "hospitalId", nullable = true)
	public Set<AlternateNumber> getAlternateNumbers() {
		return alternateNumbers;
	}

	public void setAlternateNumbers(Set<AlternateNumber> alternateNumbers) {
		this.alternateNumbers = alternateNumbers;
	}

	@Column(name = "LicenseNumber", length = 100, nullable = false)
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@Column(name = "year_of_establishment")
	@NotNull(message = "{hospital.yearOfEstablishment.notBlank}")
	@Size(max = 4, min = 4, message = "{hospital.yearOfEstablishment.size}")
	@Pattern(regexp = "[0-9]+", message = "{hospital.yearOfEstablishment.onlyDigits}")
	public String getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(String yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}

	@Column(name = "number_of_beds")
	@NotNull(message = "{hospital.numberOfBeds.notBlank}")
	@Pattern(regexp = "[0-9]+", message = "{hospital.numberOfBeds.onlyDigits}")
	@Size(max = 6, min = 0, message = "{hospital.numberOfBeds.onlyDigits}")
	// @Digits(integer = 6, fraction = 0, message =
	// "{hospital.numberOfBeds.onlyDigits}")
	public String getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(String numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	@Column(name = "hospital_type")
	@NotBlank(message = "{hospital.hospitalType.notBlank}")
	public String getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "Email", nullable = true, length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Started_In", nullable = true)
	// @Transient
	public Date getStartedIn() {
		return startedIn;
	}

	//@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setStartedIn(Date startedIn) {
		this.startedIn = startedIn;
	}

	@Column(name = "Phone_Number1", nullable = false, length = 13)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// added later
	@Column(name = "Ambulance_Service", nullable = false)
	public boolean isAmbulanceService() {
		return ambulanceService;
	}

	public void setAmbulanceService(boolean ambulanceService) {
		this.ambulanceService = ambulanceService;
	}

	@Column(name = "Business_Logo_Path", length = 255)
	// @Transient
	public String getBusinessLogoPath() {
		return businessLogoPath;
	}

	public void setBusinessLogoPath(String businessLogoPath) {
		this.businessLogoPath = businessLogoPath;
	}

	@Column(name = "Notes", length = 100)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "Fax1", length = 15)
	public String getFax1() {
		return fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	@Column(name = "Fax2", length = 15)
	public String getFax2() {
		return fax2;
	}

	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}


//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId")
	public Set<PaymentMode> getAcceptedPaymentModes() {
		return acceptedPaymentModes;
	}
	
	public void setAcceptedPaymentModes(Set<PaymentMode> acceptedPaymentModes) {
		this.acceptedPaymentModes = acceptedPaymentModes;
	}


//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId"/* , nullable = false */)
	public Set<HospitalSpecialization> getHospitalSpecializations() {
		return hospitalSpecializations;
	}



	public void setHospitalSpecializations(Set<HospitalSpecialization> hospitalSpecializations) {
		this.hospitalSpecializations = hospitalSpecializations;
	}


//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId", nullable = false)
	public Set<AvailableFacility> getAvailableFacilities() {
		return availableFacilities;
	}



	public void setAvailableFacilities(Set<AvailableFacility> availableFacilities) {
		this.availableFacilities = availableFacilities;
	}


//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "hospital_Id", referencedColumnName = "hospitalId", nullable = false)
	public Set<OperatingDaysHours> getOperatingDaysHours() {
		return operatingDaysHours;
	}



	public void setOperatingDaysHours(Set<OperatingDaysHours> operatingDaysHours) {
		this.operatingDaysHours = operatingDaysHours;
	}



	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	public boolean getIsActive() {
		return isActive;
	}

	
}
