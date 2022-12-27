package com.pytosoft.model;


import javax.validation.constraints.Min;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "complain")
public class Complain 
{

	public static final String NAME = "name";

	public static final String ID = "id";

	@Min(value = 1, message = "{complain.id.min}")
	private Integer id;

	
	private String name;

	

	public Complain()
	{

	}

	public Complain(Integer id)
	{
		super();
		this.id = id;
	}

	public Complain(final Integer id, final String name)
	{
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

	@Column(name = "Name", nullable = false, length = 255)
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

}
