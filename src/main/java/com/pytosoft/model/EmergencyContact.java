package com.pytosoft.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.pytosoft.constraint.Alpha;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emergency_contact")
public class EmergencyContact
{
	private long id;

	@NotBlank(message = "{emergencyContact.contactPerson.notBlank}")
	@Alpha(message = "{emergencyContact.contactPerson.alpha}")
	@Size(max = 50, message = "{emergencyContact.contactPerson.size}")
	private String contactPerson;

	@NotBlank(message = "{emergencyContact.contactNumber.notBlank}")
	@Size(max = 11, min = 10, message = "{emergencyContact.contactNumber.size}")
	@Pattern(regexp = "[0-9]+", message = "{emergencyContact.contactNumber.regex}")
	private String contactNumber;

	@Size(max = 50, message = "{emergencyContact.relation.size}")
	@Pattern(regexp = "[a-zA-Z]+[ a-zA-Z-_]*", message = "{emergencyContact.relation.regex}")
	private String relation;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@Column(name = "Contact_Person", nullable = false, length = 50)
	public String getContactPerson()
	{
		return contactPerson;
	}

	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}

	@Column(name = "Contact_Number", nullable = false, length = 11)
	public String getContactNumber()
	{
		return contactNumber;
	}

	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}

	@Column(name = "Relation", nullable = true, length = 50)
	public String getRelation()
	{
		return relation;
	}

	public void setRelation(String relation)
	{
		this.relation = relation;
	}

}
