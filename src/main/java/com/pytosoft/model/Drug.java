package com.pytosoft.model;

import java.io.Serializable;

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
@Table(name = "drug")
public class Drug implements Serializable
{

	private static final long serialVersionUID = -3072256479874153026L;

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String GENERICNAME = "genericName";

	public static final String DRUGCLASS = "drugClass";

	public static final String BRANDNAME = "brandName";

//	@NotNull(groups = { CreateVisit.class }, message = "{drug.id.notNull}")
//	@Min(groups = { CreateDrug.class, CreateEntity.class, CreateVisit.class }, value = 1, message = "{drug.id.min}")
//	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

//	@NotNull(groups = { CreateDrug.class }, message = "{drug.name.notNull}")
//	@Size(groups = { CreateDrug.class }, max = 255, message = "{drug.name.size}")
	//@NotHtml(groups = { CreateDrug.class }, message = "{drug.name.notHtml}")
	private String name;

	private String strength;

	private String drugClass;

	private String genericName;

	private String drugForm;

	private String brandName;

	private boolean userDefined;

	public Drug()
	{

	}

	public Drug(long id)
	{
		super();
		this.id = id;
	}

	public Drug(Long id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	
	public Long getId()
	{
		return id;
	}

	@Column(name = "Name", length = 255, nullable = false)
	public String getName()
	{
		return name;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "Strength", length = 15, nullable = true)
	public String getStrength()
	{
		return strength;
	}

	public void setStrength(String strength)
	{
		this.strength = strength;
	}

	@Column(name = "Drug_Class", length = 100, nullable = true)
	public String getDrugClass()
	{
		return drugClass;
	}

	public void setDrugClass(String drugClass)
	{
		this.drugClass = drugClass;
	}

	@Column(name = "Generic_Name", length = 100, nullable = true)
	public String getGenericName()
	{
		return genericName;
	}

	public void setGenericName(String genericName)
	{
		this.genericName = genericName;
	}

	@Column(name = "Drug_Form", length = 100, nullable = true)
	public String getDrugForm()
	{
		return drugForm;
	}

	public void setDrugForm(String drugForm)
	{
		this.drugForm = drugForm;
	}

	@Column(name = "Brand_Name", length = 100, nullable = true)
	public String getBrandName()
	{
		return brandName;
	}

	public void setBrandName(String brandName)
	{
		this.brandName = brandName;
	}

	@Override
	public String toString()
	{
		return "Drug [name=" + name + "]";
	}

	@Column(name = "Is_User_Defined", nullable = false)
	public boolean getIsUserDefined()
	{
		return userDefined;
	}

	public void setIsUserDefined(boolean isUserDefined)
	{
		this.userDefined = isUserDefined;
	}

}

