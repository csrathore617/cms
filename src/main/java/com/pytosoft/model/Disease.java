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
@Table(name = "disease")
public class Disease /* implements SingleTenantOwned */
{
	private static final long serialVersionUID = -8099560638359278304L;

	public static final String NAME = "name";

	public static final String ACTIVE = "active";

	public static final String PRE_CONDITION = "preCondition";

	public static final String ID = "id";

	@Min(value = 1, message = "{disease.id.min}")
	private Long id;

	@NotNull(groups = { CreateEntity.class }, message = "{disease.name.notNull}")
	@Size(groups = { CreateEntity.class }, max = 255, message = "{disease.name.size}")
//	@NotHtml(groups = { CreateEntity.class }, message = "{disease.name.NotHtml}")
	private String name;

	private Boolean active;

//	private Tenant tenant;

	private Boolean preCondition;

	public Disease()
	{
	}

	public Disease(Long id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@Column(name = "Name", nullable = false, length = 255)
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

	@Column(name = "Is_Active")
	public Boolean getActive()
	{
		return active;
	}

	public void setActive(Boolean active)
	{
		this.active = active;
	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Tenant_Id", referencedColumnName = "Id")
////	@JSON(include = false)
//	@JsonIgnore
//	public Tenant getTenant()
//	{
//		return tenant;
//	}
//
//	public void setTenant(Tenant tenant)
//	{
//		this.tenant = tenant;
//	}

	@Column(name = "Is_Pre_Condition", nullable = true)
	public Boolean isPreCondition()
	{
		return preCondition;
	}

	public void setPreCondition(Boolean preCondition)
	{
		this.preCondition = preCondition;
	}
}