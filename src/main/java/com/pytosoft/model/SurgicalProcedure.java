package com.pytosoft.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pytosoft.constraint.CreateEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "surgical_procedure")
public class SurgicalProcedure {
	public static final String NAME = "name";
	
	public static final String ID = "id";

	@Min(value = 1, message = "{surgicalProcedure.id.min}")
	private Short id;

	@NotNull(groups = { CreateEntity.class }, message = "{surgicalProcedure.name.notNull}")
	@Size(groups = { CreateEntity.class }, max = 255, message = "{surgicalProcedure.name.size}")
	//@NotHtml(groups = { CreateEntity.class }, message = "{surgicalProcedure.name.NotHtml}")
	private String name;

	public SurgicalProcedure()
	{
	}

	public SurgicalProcedure(Short id)
	{
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

	@Column(name = "Name", nullable = false, length = 255)
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
