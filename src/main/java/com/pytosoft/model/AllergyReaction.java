package com.pytosoft.model;

import javax.validation.constraints.Min;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "allergy_reaction")
public class AllergyReaction
{
	public static final String NAME = "name";

	@Min(value = 1, message = "{allergyreaction.id.min}")
	private Short id;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Short getId()
	{
		return id;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName()
	{
		return name;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
