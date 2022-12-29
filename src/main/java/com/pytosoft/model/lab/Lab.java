package com.pytosoft.model.lab;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pytosoft.constraint.CreateEntity;
import com.pytosoft.model.Address;
import com.pytosoft.model.Hospital;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "lab")
@BatchSize(size = 20)
public class Lab /* implements SingleTenantOwned */
{
	private static final long serialVersionUID = -7236343017570988529L;

	public static final String NAME = "name";

	public static final String ADDRESS = "address";

	public static final String ID = "id";
	
	public static final String ACTIVE = "active";

	public static final String HOSPITAL = "hospital";

	@NotNull(groups = { CreateEntity.class }, message = "{lab.id.notNull}")
	@Min(groups = { CreateEntity.class }, value = 1, message = "{lab.id.min}")
	private Integer id;

	@NotBlank(message = "{lab.name.notBlank}")
	@Size(max = 100, message = "{lab.name.size}")
	private String name;

	@Email(message = "{lab.email.email}")
	private String email;

	@NotBlank(message = "{lab.contactNumber.notBlank}")
	@Size(max = 11, min = 10, message = "{lab.contactNumber.size}")
	@Pattern(regexp = "[0-9]+", message = "{lab.contactNumber.regex}")
	private String contactNumber;

	@Size(max = 30, message = "{lab.primaryContactPerson.size}")
//	@Alpha(message = "{lab.primaryContactPerson.regex}")
	private String primaryContactPerson;

	@Size(max = 11, min = 10, message = "{lab.otherContactNumber.size}")
	@Pattern(regexp = "[0-9]+", message = "{lab.otherContactNumber.regex}")
	private String otherContactNumber;

	@Size(max = 13, min = 11, message = "{lab.fax.size}")
	@Pattern(regexp = "[0-9]+", message = "{lab.fax.regex}")
	private String fax;

	@Size(max = 13, min = 11, message = "{lab.fax1.size}")
	@Pattern(regexp = "[0-9]+", message = "{lab.fax1.regex}")
	private String fax1;

	@NotBlank(message = "{lab.licenseNumber.notBlank}")
	@Size(max = 100, message = "{lab.licenseNumber.size}")
	@Pattern(regexp="^([0-9|a-z|A-Z|\\-|\\/\\|/S])+" , message="{lab.licenseNumber.alphanumeric}")
	private String licenseNumber;

	@NotNull(message = "{lab.address.notNull}")
	@Valid
	private Address address;
	
	@NotBlank(message = "{lab.type.notBlank}")
	@Size(max = 100, message = "{lab.type.size}")
	private String type;
	
	@NotBlank(message = "{lab.speciality.notBlank}")
	@Size(max = 100, message = "{lab.speciality.size}")
	private String speciality;

	// for ui only

//	private List<LabUser> labUsers;

//	private List<AvailableMedicalTest> availableMedicalTests;

//	private Tenant tenant;
	
	private boolean active;
	
	private Hospital hospital;

	public Lab()
	{

	}

	public Lab(Integer id)
	{
		super();
		this.id = id;
	}

	public Lab(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	@Column(name = "Name", length = 100, nullable = false)
	public String getName()
	{
		return name;
	}

	@Column(name = "Email", length = 100)
	public String getEmail()
	{
		return email;
	}

	@Column(name = "Contact_Number", length = 15, nullable = false)
	public String getContactNumber()
	{
		return contactNumber;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Address_Id", referencedColumnName = "Id")
	//@JSON(include = false)
	//@JsonIgnore
	public Address getAddress()
	{
		return address;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	@Column(name = "Primary_Contact_Person", length = 100, nullable = false)
	public String getPrimaryContactPerson()
	{
		return primaryContactPerson;
	}

	public void setPrimaryContactPerson(String primaryContactPerson)
	{
		this.primaryContactPerson = primaryContactPerson;
	}

	@Column(name = "Other_Contact_Number", length = 15, nullable = true)
	public String getOtherContactNumber()
	{
		return otherContactNumber;
	}

	public void setOtherContactNumber(String otherContactNumber)
	{
		this.otherContactNumber = otherContactNumber;
	}

	@Column(name = "Fax", length = 15, nullable = true)
	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	@Column(name = "LicenseNumber", length = 100, nullable = false)
	public String getLicenseNumber()
	{
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber)
	{
		this.licenseNumber = licenseNumber;
	}

	/*
	 * // for ui only
	 * 
	 * @Transient public List<LabUser> getLabUsers() { return labUsers; }
	 * 
	 * public void setLabUsers(List<LabUser> labUsers) { this.labUsers = labUsers; }
	 * 
	 * @Transient public List<AvailableMedicalTest> getAvailableMedicalTests() {
	 * return availableMedicalTests; }
	 * 
	 * public void setAvailableMedicalTests(List<AvailableMedicalTest>
	 * availableMedicalTests) { this.availableMedicalTests = availableMedicalTests;
	 * }
	 */

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "Hospital_Id", referencedColumnName = "hospitalId")
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	/*
	 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional =
	 * true)
	 * 
	 * @JoinColumn(name = "Tenant_Id", referencedColumnName = "Id")
	 * 
	 * @JSON(include = false)
	 * 
	 * @JsonIgnore public Tenant getTenant() { return tenant; }
	 * 
	 * public void setTenant(Tenant tenant) { this.tenant = tenant; }
	 */
	@Column(name = "Fax1", length = 15, nullable = true)
	public String getFax1()
	{
		return fax1;
	}

	public void setFax1(String fax1)
	{
		this.fax1 = fax1;
	}
	
	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "Type", length = 100, nullable = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "Speciality", length = 100, nullable = true)
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public boolean notNew()
	{
		return getId() != null && getId() > 0;
	}

	public void merge(Lab lab)
	{
		this.name=lab.getName();
		this.licenseNumber=lab.getLicenseNumber();
		this.speciality=lab.getSpeciality();
		this.contactNumber=lab.getContactNumber();
		this.otherContactNumber=lab.getOtherContactNumber();
		this.fax=lab.getFax();
		this.fax1=lab.getFax1();
		this.email=lab.getEmail();
		this.address=lab.getAddress();
	}
}
