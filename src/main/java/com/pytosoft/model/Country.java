package com.pytosoft.model;




import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.*;



@Entity
@Table(name = "country")
//@BatchSize(size = 10)
public class Country 
{

	//private static final long serialVersionUID = 6450099815044126150L;

	@NotNull(message = "country.id.notNull}")
	@Min(value = 1, message = "{country.id.min}")
	private Short id;

	private String name;

	public Country()
	{

	}

	public Country(Short id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Override
	public String toString()
	{
		return "Country [id=" + id + ", name=" + name + "]";
	}

}
