package com.pytosoft.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility 
{
	/**
	 * 
	 */
	//private static final long serialVersionUID = -1344797875320627789L;

	@NotNull(message = "{facility.id.notNull}")
	@Min(value = 1, message = "{facility.id.min}")
	private Short id;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	@Column(name = "Name", length = 255/* , nullable = false */)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
