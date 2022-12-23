package com.pytosoft.model;




import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name = "state")
//@BatchSize(size = 10)
public class State 
{
	private static final long serialVersionUID = 2579793149287470218L;

	public static final String COUNTRY = "country";

	public static final String NAME = "name";

	@NotNull(message = "state.id.notNull}")
	@Min(value = 1, message = "{state.id.min}")
	private Integer id;

	private String name;

//	private Country country;
//
//	@ManyToOne(optional = false,cascade = CascadeType.ALL)
//	@JoinColumn(name = "Country_Id", referencedColumnName = "Id")
//	//@JsonIgnore
//	public Country getCountry()
//	{
//		return country;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	@Column(name = "name", nullable = false, length = 75)
	public String getName()
	{
		return name;
	}

//	public void setCountry(Country country)
//	{
//		this.country = country;
//	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + "]";
	}

	

}
