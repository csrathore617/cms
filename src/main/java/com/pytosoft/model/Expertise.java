package com.pytosoft.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expertise")
public class Expertise implements Serializable
{
	private static final long serialVersionUID = -5277378000605340186L;

	private Long id;

	@Size(max = 50, message = "{expertise.name.size}")
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "Name", nullable = true, length = 50)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
