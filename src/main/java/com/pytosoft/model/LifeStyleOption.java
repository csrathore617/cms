package com.pytosoft.model;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "life_style_option")
@BatchSize(size = 20)
public class LifeStyleOption {
	public static final String NAME = "name";

	public static final String ID = "id";

	private Integer id;

	private String name;

	public LifeStyleOption()
	{

	}

	public LifeStyleOption(Integer id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	@Column(name = "Name", length = 255, nullable = false)
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

	@Override
	public String toString()
	{
		return "Life Style Option [name=" + name + "]";
	}

	public boolean hasId()
	{
		return id != null && id > 0;
	}

}

