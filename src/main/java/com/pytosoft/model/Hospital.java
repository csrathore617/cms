package com.pytosoft.model;



import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.*;


@Entity
@Table(name = "hospital")
//@DiscriminatorValue("HOSPITALCLINIC")
//@PrimaryKeyJoinColumn(name = "Id", referencedColumnName = "Id")

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hospitalId")
	
	private Integer hospitalId;
	
	
	@NotBlank(message = "{hospital.licenseNumber.notBlank}")
	@Size(max = 10, message = "{hospital.licenseNumber.size}")
	@Pattern(regexp="^([0-9|a-z|A-Z|\\-|\\/\\|/S])+" , message="{hospital.licenseNumber.alphanumeric}")
	private String licenseNumber;

	private String yearOfEstablishment;

	private String numberOfBeds;

	private String hospitalType;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="hospital_Id", referencedColumnName = "hospitalId")
	private Set<AlternateNumber> alternateNumbers;
	
	public Hospital()
	{

	}

//	public Hospital(Set<AlternateNumber> alternateNumbers,
//			@Size(max = 10, message = "{hospital.licenseNumber.size}") @Pattern(regexp = "^([0-9|a-z|A-Z|\\-|\\/\\|/S])+", message = "{hospital.licenseNumber.alphanumeric}") String licenseNumber,
//			String yearOfEstablishment, String numberOfBeds, String hospitalType) {
//		super();
//		this.alternateNumbers = alternateNumbers;
//		this.licenseNumber = licenseNumber;
//		this.yearOfEstablishment = yearOfEstablishment;
//		this.numberOfBeds = numberOfBeds;
//		this.hospitalType = hospitalType;
//	}

	

	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JoinColumn(name = "Hospital_id", referencedColumnName = "Id", nullable = true)
	public Set<AlternateNumber> getAlternateNumbers()
	{
		return alternateNumbers;
	}

	public void setAlternateNumbers(Set<AlternateNumber> alternateNumbers)
	{
		this.alternateNumbers = alternateNumbers;
	}

	@Column(name = "LicenseNumber", length = 100, nullable = false)
	public String getLicenseNumber()
	{
		return licenseNumber;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setLicenseNumber(String licenseNumber)
	{
		this.licenseNumber = licenseNumber;
	}
	
	@Column(name = "year_of_establishment")
	@NotNull(message = "{hospital.yearOfEstablishment.notBlank}")
	@Size(max = 4, min = 4, message = "{hospital.yearOfEstablishment.size}")
	@Pattern(regexp = "[0-9]+", message = "{hospital.yearOfEstablishment.onlyDigits}")
	public String getYearOfEstablishment()
	{
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(String yearOfEstablishment)
	{
		this.yearOfEstablishment = yearOfEstablishment;
	}

	@Column(name = "number_of_beds")
	@NotNull(message = "{hospital.numberOfBeds.notBlank}")
	@Pattern(regexp = "[0-9]+", message = "{hospital.numberOfBeds.onlyDigits}")
	@Size(max = 6, min = 0, message = "{hospital.numberOfBeds.onlyDigits}")
	// @Digits(integer = 6, fraction = 0, message =
	// "{hospital.numberOfBeds.onlyDigits}")
	public String getNumberOfBeds()
	{
		return numberOfBeds;
	}

	public void setNumberOfBeds(String numberOfBeds)
	{
		this.numberOfBeds = numberOfBeds;
	}

	@Column(name = "hospital_type")
	@NotBlank(message = "{hospital.hospitalType.notBlank}")
	public String getHospitalType()
	{
		return hospitalType;
	}

	public void setHospitalType(String hospitalType)
	{
		this.hospitalType = hospitalType;
	}
}

