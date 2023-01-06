package com.pytosoft.model;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import jakarta.persistence.Table;





@Entity
@Table(name = "clinic")
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "Clinic_Type", discriminatorType = DiscriminatorType.STRING, length = 20)
//@BatchSize(size = 10)
public class Clinic 
{
//	@SuppressWarnings("unused")
	//private static final long serialVersionUID = -352911380775268279L;

	public static final String NAME = "name";

	public static final String ADDRESS = "address";

	public static final String ID = "id";

	public static final String OPERATING_DAYS = "operatingDaysHours";

	public static final String HOSPITAL = "hospital";

	public static final String DOCTOR_CLINIC_ASSIGNMENTS = "doctorClinicAssignments";

	public static final String CLINIC_GEO_LOCATION = "clinicGeoLocation";
	
	public static final String ACTIVE = "active";

	public static final String CLINIC_SPECIALIZATIONS ="clinicSpecializations";

	public static final String AVAILABLE_FACILITIES ="availableFacilities";
	
	@NotNull( message = "{clinic.id.notNull}")
	@Min( value = 1, message = "{clinic.id.min}")
	private Integer id;

	@NotBlank(message = "{clinic.name.notBlank}")
	@Size(max = 100, min = 10, message = "{clinic.name.size}")
	//@NotHtml(message = "{clinic.name.notHtml}")
	private String name;

	//@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{clinic.email.email}")
	private String email;

	//@Past(message = "{clinic.startedIn.past}")
	private Date startedIn;

	@NotNull(message = "{clinic.address.notNull}")
	@Valid
	private Address address;

	@NotBlank(message = "{clinic.phoneNumber.notBlank}")
	//@Size(max = 10, min = 10, message = "{clinic.phoneNumber.size}")
	//@Pattern(regexp = "[0-9]+", message = "{clinic.phoneNumber.regex}")
	private String phoneNumber1;

	//@Size(max = 10, min = 10, message = "{hospital.alternateNumber.size}")
	//@Pattern(regexp = "[0-9]+", message = "{hospital.alternateNumber.regex}")
	private String phoneNumber2;

	//@Size(max = 10, min = 10, message = "{clinic.phoneNumber.size}")
	//@Pattern(regexp = "[0-9]+", message = "{clinic.phoneNumber.regex}")
	private String phoneNumber3;

	@Valid
	private Set<PaymentMode> acceptedPaymentModes;

	private boolean ambulanceService;
	
	private boolean active;

//	@Deprecated
//	private String acceptedPaymentMode;ac

	@Size(max = 255, message = "{clinic.businessLogoPath.size}")
	private String businessLogoPath;

	@Size(max = 255, message = "{clinic.notes.size}")
	//@NotHtml(message = "{clinic.notes.notHtml}")
	private String notes;

	//@Size(max = 15, min = 10, message = "{clinic.fax1.size}")
	//@Pattern(regexp = "[0-9]+", message = "{clinic.fax1.regex}")
	private String fax1;

	//@Size(max = 15, min = 10, message = "{clinic.fax2.size}")
	//@Pattern(regexp = "[0-9]+", message = "{clinic.fax2.regex}")
	private String fax2;

	
	private Set<ClinicSpecialization> clinicSpecializations;

	@Valid
	private Set<AvailableFacility> availableFacilities;

	private Set<OperatingDaysHours> operatingDaysHours;

//	@ManyToOne(fetch = FetchType.LAZY, optional = true,cascade = CascadeType.ALL)
//	@JoinColumn(name = "Doctor_Id", referencedColumnName = "Id")
//	private Doctor doctor;
//	
//	@ManyToOne(fetch = FetchType.LAZY, optional = true,cascade = CascadeType.ALL)
//	@JoinColumn(name = "Patient_Id", referencedColumnName = "Id")
//	private Patient patient;

//	private ClinicGeoLocation clinicGeoLocation;
//
//	// only for ui purpose
//	private List<DoctorVO> assignedDoctors;

	private boolean hospital;

	public Clinic()
	{

	}

	public Clinic(Integer id)
	{
		super();
		this.id = id;
	}

	public Clinic(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}
	
	

	public Clinic(Integer id, String name, String email, Date startedIn, Address address, String phoneNumber1,
			String phoneNumber2, String phoneNumber3, Set<PaymentMode> acceptedPaymentModes, boolean ambulanceService,
			boolean active, String businessLogoPath, String notes, String fax1, String fax2,
			Set<ClinicSpecialization> clinicSpecializations, Set<AvailableFacility> availableFacilities,
			Set<OperatingDaysHours> operatingDaysHours, boolean hospital) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.startedIn = startedIn;
		this.address = address;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.phoneNumber3 = phoneNumber3;
		this.acceptedPaymentModes = acceptedPaymentModes;
		this.ambulanceService = ambulanceService;
		this.active = active;
		this.businessLogoPath = businessLogoPath;
		this.notes = notes;
		this.fax1 = fax1;
		this.fax2 = fax2;
		this.clinicSpecializations = clinicSpecializations;
		this.availableFacilities = availableFacilities;
		this.operatingDaysHours = operatingDaysHours;
		this.hospital = hospital;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName()
	{
		return name;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	@Column(name = "Email", nullable = true, length = 255)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "Started_In", nullable = true)
	//@Transient
	public Date getStartedIn()
	{
		return startedIn;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setStartedIn(Date startedIn)
	{
		this.startedIn = startedIn;
	}

	@Column(name = "Phone_Number1", nullable = false, length = 13)
	public String getPhoneNumber1()
	{
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1)
	{
		this.phoneNumber1 = phoneNumber1;
	}

	@Column(name = "Phone_Number2", nullable = true, length = 13)
	public String getPhoneNumber2()
	{
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2)
	{
		this.phoneNumber2 = phoneNumber2;
	}

	@Column(name = "Phone_Number3", nullable = true, length = 13)
	public String getPhoneNumber3()
	{
		return phoneNumber3;
	}

	public void setPhoneNumber3(String phoneNumber3)
	{
		this.phoneNumber3 = phoneNumber3;
	}

//	@Transient
//	public List<DoctorVO> getAssignedDoctors()
//	{
//		return assignedDoctors;
//	}
//
//	public void setAssignedDoctors(List<DoctorVO> assignedDoctors)
//	{
//		this.assignedDoctors = assignedDoctors;
//	}

	// added later
	@Column(name = "Ambulance_Service", nullable = false)
	public boolean isAmbulanceService()
	{
		return ambulanceService;
	}

	public void setAmbulanceService(boolean ambulanceService)
	{
		this.ambulanceService = ambulanceService;
	}
	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

//	@Deprecated
//	@Column(name = "Accepted_Payment_Mode", length = 50)
//	public String getAcceptedPaymentMode()
//	{
//		return acceptedPaymentMode;
//	}

//	@Deprecated
//	public void setAcceptedPaymentMode(String acceptedPaymentMode)
//	{
//		this.acceptedPaymentMode = acceptedPaymentMode;
//	}

	@Column(name = "Business_Logo_Path", length = 255)
	//@Transient
	public String getBusinessLogoPath()
	{
		return businessLogoPath;
	}

	public void setBusinessLogoPath(String businessLogoPath)
	{
		this.businessLogoPath = businessLogoPath;
	}

	@Column(name = "Notes", length = 100)
	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	@Column(name = "Fax1", length = 15)
	public String getFax1()
	{
		return fax1;
	}

	public void setFax1(String fax1)
	{
		this.fax1 = fax1;
	}

	@Column(name = "Fax2", length = 15)
	public String getFax2()
	{
		return fax2;
	}

	public void setFax2(String fax2)
	{
		this.fax2 = fax2;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id")
	public Set<ClinicSpecialization> getClinicSpecializations()
	{
		return clinicSpecializations;
	}

	public void setClinicSpecializations(Set<ClinicSpecialization> clinicSpecializations)
	{
		this.clinicSpecializations = clinicSpecializations;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id"/* , nullable = false */)
	public Set<AvailableFacility> getAvailableFacilities()
	{
		return availableFacilities;
	}

	public void setAvailableFacilities(Set<AvailableFacility> availableFacilities)
	{
		this.availableFacilities = availableFacilities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)


	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id")

	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id" /*, nullable = false*/)


	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id" /*, nullable = false*/)

	public Set<PaymentMode> getAcceptedPaymentModes()
	{
		return acceptedPaymentModes;
	}

	public void setAcceptedPaymentModes(Set<PaymentMode> acceptedPaymentModes)
	{
		this.acceptedPaymentModes = acceptedPaymentModes;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)


	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id")

	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id" )


	@JoinColumn(name = "Clinic_Id", referencedColumnName = "Id" )

	public Set<OperatingDaysHours> getOperatingDaysHours()
	{
		return operatingDaysHours;
	}

	public void setOperatingDaysHours(Set<OperatingDaysHours> operatingDaysHours)
	{
		this.operatingDaysHours = operatingDaysHours;
	}

	@Column(name = "hospital", nullable = true)
	public boolean isHospital()
	{
		return hospital;
	}

	public void setHospital(boolean hospital)
	{
		this.hospital = hospital;
	}

	
//	public Doctor getDoctor()
//	{
//		return doctor;
//	}
//
//	public void setDoctor(Doctor doctor)
//	{
//		this.doctor = doctor;
//	}
//	
//	
//	public Patient getPatient()
//	{
//		return patient;
//	}
//
//	public void setPatient(Patient patient)
//	{
//		this.patient = patient;
//	}

//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "clinic")
//	@JsonIgnore
//	@JSON(include = false)
//	public ClinicGeoLocation getClinicGeoLocation()
//	{
//		return clinicGeoLocation;
//	}
//
//	public void setClinicGeoLocation(ClinicGeoLocation clinicGeoLocation)
//	{
//		this.clinicGeoLocation = clinicGeoLocation;
//	}

}
