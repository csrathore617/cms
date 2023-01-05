package com.pytosoft.model.procedure;

import javax.validation.constraints.Min;

import org.hibernate.annotations.BatchSize;

import com.pytosoft.constraint.CreateProcedure;
import com.pytosoft.constraint.CreateVisit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vital")
@BatchSize(size = 20)
public class Vital /* implements SingleTenantOwned */
{
//	private static final long serialVersionUID = 3677985084623366300L;

	public static final String NAME = "name";

	public static final String ID = "id";

	@Min(groups = { CreateProcedure.class ,CreateVisit.class}, value = 1, message = "{vitals.id.min}")
	private Integer id;

	private String name;

//	private Tenant tenant;

	public Vital()
	{

	}

	public Vital(Integer id)
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

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Tenant_Id", referencedColumnName = "Id")
//	@JSON(include = false)
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

	@Override
	public String toString()
	{
		return "Diagnosis [name=" + name + "]";
	}

	public boolean hasId()
	{
		return id != null && id > 0;
	}

}