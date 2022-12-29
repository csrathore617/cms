package com.pytosoft.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DialectOverride.Formula;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.pytosoft.constraint.Alpha;
import com.pytosoft.constraint.CreateEntity;
import com.pytosoft.constraint.CreateHospitalAdmin;
import com.pytosoft.constraint.CreateSchedule;
import com.pytosoft.constraint.DoctorAssignment;
import com.pytosoft.constraint.UpdateSchedule;
import com.pytosoft.model.Address;
import com.pytosoft.model.Doctor;
import com.pytosoft.model.Patient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING, length = 10)
//@FetchProfiles({
//		@FetchProfile(name = "patient_address_fetch_profile", fetchOverrides = { @FetchProfile.FetchOverride(entity = Patient.class, association = "address", mode = FetchMode.JOIN) }),
//		@FetchProfile(name = "doctor_fetch_profile", fetchOverrides = { @FetchProfile.FetchOverride(entity = Doctor.class, association = "address", mode = FetchMode.JOIN) }) })
public class AppUser implements Serializable
{
	private static final long serialVersionUID = -923677343129369887L;

	public static final String REGISTRATION_ID = "id";

	public static final String FIRST_NAME = "firstName";

	public static final String MIDDLE_NAME = "middleName";

	public static final String LAST_NAME = "lastName";

	public static final String USER_NAME = "userName";

	public static final String FP_PATIENT_ADDRESS = "patient_address_fetch_profile";

	public static final String FP_DOCTOR_ADDRESS = "doctor_fetch_profile";

	public static final String CREATED_ON = "createdOn";

	public static final String MOBILE = "mobile";

	public static final String ADDRESS = "address";

	public static final String ASSIGNED_ROLES = "assignedRoles";

	public static final String EMAIL = "email";

	public static final String PASSWORD = "password";

	public static final String FULL_NAME = "fullName";

	public static final String ACTIVE = "active";

	@NotNull(groups = { UpdateSchedule.class, CreateSchedule.class, DoctorAssignment.class, Default.class,
			CreateEntity.class }, message = "{appUser.id.notNull}")
	@Min(groups = { UpdateSchedule.class, CreateSchedule.class, DoctorAssignment.class, Default.class,
			CreateEntity.class }, value = 1, message = "{appUser.id.min}")
	private Long id;

	private String userType;

	private String userName;

	private String password;

	@NotBlank(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.firstName.notBlank}")
	@Size(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.firstName.size}", max = 50)
	@Alpha(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.firstName.alpha}")
	protected String firstName;

	@Size(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.middleName.size}", max = 50)
	@Alpha(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.middleName.alpha}")
	protected String middleName;

	@NotBlank(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.lastName.notBlank}")
	@Size(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.lastName.size}", max = 50)
	@Alpha(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.lastName.alpha}")
	protected String lastName;

	@NotBlank(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.email.notBlank}")
	@Email(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.email.email}")
	protected String email;

	@NotBlank(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.mobile.notBlank}")
	@Size(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.mobile.size}", min = 10, max = 10)
	@Digits(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.mobile.digits}", fraction = 0, integer = 10)
	protected String mobile;

	private String homePhone;

	protected Set<UserRole> assignedRoles;

	private Address address;

	private boolean active = false;

	private boolean enabled = false;

	private boolean loginCreated;

	private Date createdOn;

	@NotBlank(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.sex.notBlank}")
	protected String sex;

	// newly added
	private String saluation;

	private String uniqueId;

	private String maritalStatus;

	@Size(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.otherContactNumber.size}", min = 10, max = 10)
	@Digits(groups = { CreateHospitalAdmin.class }, message = "{hospitalAdmin.otherContactNumber.digits}", fraction = 0, integer = 10)
	private String otherContactNumber;

	private String profilePicPath;

	private String interest;

	private String languages;

	private Date dateOfBirth;

	private String fullName;

	public AppUser()
	{

	}

	public AppUser(Long userId)
	{
		super();
		this.id = userId;
	}

	public AppUser(String firstName, String middleName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public void assignRole(UserRole anUserRole)
	{
		if (this.assignedRoles == null)
		{
			this.assignedRoles = new HashSet<UserRole>();
		}
		//anUserRole.setAppUser(this);
		this.assignedRoles.add(anUserRole);
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", nullable = true)
	public Address getAddress()
	{
		return address;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "App_User_Id",referencedColumnName = "Id")
	public Set<UserRole> getAssignedRoles()
	{
		return assignedRoles;
	}

	@Column(name = "Mobile_Number", length = 15, nullable = true)
	public String getMobile()
	{
		return mobile;
	}

	@Column(name = "Email", length = 100, nullable = true)
	public String getEmail()
	{
		return email;
	}

	@Column(name = "First_Name", length = 30, nullable = false)
	public String getFirstName()
	{
		return firstName;
	}

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return id;
	}

	@Column(name = "Last_Name", length = 30, nullable = false)
	public String getLastName()
	{
		return lastName;
	}

	@Column(name = "Middle_Name", length = 30, nullable = true)
	public String getMiddleName()
	{
		return middleName;
	}

	@Column(name = "Password", length = 100, nullable = false)
	public String getPassword()
	{
		return password;
	}

	@Column(name = "User_Name", length = 255, nullable = false)
	public String getUserName()
	{
		return userName;
	}

	@Column(name = "USER_TYPE", length = 10)
	public String getUserType()
	{
		return userType;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive()
	{
		return active;
	}

	@Column(name = "Enabled", length = 10)
	public boolean isEnabled()
	{
		return enabled;
	}

	@Column(name = "Home_Phone", length = 15, nullable = true)
	public String getHomePhone()
	{
		return homePhone;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public void setAssignedRoles(Set<UserRole> assignedRoles)
	{
		this.assignedRoles = assignedRoles;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public void setHomePhone(String homePhone)
	{
		this.homePhone = homePhone;
	}

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	@Column(name = "Sex", length = 15)
	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Column(name = "Login_Created", nullable = false)
	public boolean isLoginCreated()
	{
		return loginCreated;
	}

	public void setLoginCreated(boolean loginCreated)
	{
		this.loginCreated = loginCreated;
	}

	// newly added
	@Column(name = "Saluation", nullable = true, length = 50)
	public String getSaluation()
	{
		return saluation;
	}

	public void setSaluation(String saluation)
	{
		this.saluation = saluation;
	}

	@Column(name = "Unique_Id", nullable = true, length = 100)
	public String getUniqueId()
	{
		return uniqueId;
	}

	public void setUniqueId(String uniqueId)
	{
		this.uniqueId = uniqueId;
	}

	@Column(name = "Marital_Status", nullable = true, length = 50)
	public String getMaritalStatus()
	{
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus)
	{
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "Other_Contact_Number", nullable = true, length = 20)
	public String getOtherContactNumber()
	{
		return otherContactNumber;
	}

	public void setOtherContactNumber(String otherContactNumber)
	{
		this.otherContactNumber = otherContactNumber;
	}

	@Column(name = "Profile_Pic_Path", nullable = true, length = 1000)
	public String getProfilePicPath()
	{
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath)
	{
		this.profilePicPath = profilePicPath;
	}

	@Column(name = "Date_Of_Birth", nullable = true)
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "Interest", nullable = true, length = 255)
	public String getInterest()
	{
		return interest;
	}

	public void setInterest(String interest)
	{
		this.interest = interest;
	}

	@Column(name = "Language", nullable = true, length = 100)
	public String getLanguages()
	{
		return languages;
	}

	public void setLanguages(String languages)
	{
		this.languages = languages;
	}

	
	//@Formula("concat(First_Name, ' ', Last_Name)")
	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public boolean hasId()
	{
		return id != null && id > 0;
	}

	public void assignRole(Role role)
	{
		UserRole userRole = new UserRole(role);
		//userRole.setAppUser(this);
		if (this.assignedRoles == null)
		{
			assignedRoles = new HashSet<UserRole>();
		}
		assignedRoles.add(userRole);
	}

}
