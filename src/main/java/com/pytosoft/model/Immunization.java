package com.pytosoft.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "immunization")
public class Immunization {
	@NotNull(message = "{immunization.id.notNull}")
	@Min(value = 1, message = "{immunization.id.min}")
	private Short id;

	@NotNull(groups = { CreateEntity.class }, message = "{immunization.name.notNull}")
	@Size(groups = { CreateEntity.class }, max = 255, message = "{immunization.name.size}")
//	@NotHtml(groups = { CreateEntity.class }, message = "{immunization.name.notHtml}")
	private String name;

	public Immunization() {
		super();
	}

	public Immunization(Short id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Short getId()
	{
		return id;
	}

	@Column(name = "Name", nullable = false, length = 100)
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
