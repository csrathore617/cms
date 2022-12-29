package com.pytosoft.model.procedure;

import javax.validation.constraints.Min;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pytosoft.constraint.CreateProcedure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "operative_param")
@BatchSize(size = 20)
public class OperativeParam /* implements SingleTenantOwned */
 {
	private static final long serialVersionUID = 3677985084623366300L;

	public static final String NAME = "name";

	public static final String ID = "id";

	@Min(groups = { CreateProcedure.class }, value = 1, message = "{operativeParams.id.min}")
	private Integer id;

	private String name;

//	private OperativeParamType type;
	
	private String perativeParamType;

	
	private Integer ordering;

//	private Tenant tenant;

	public OperativeParam()
	{

	}

	public OperativeParam(Integer id)
	{
		this.id = id;
	}

	public OperativeParam(String name,/* OperativeParamType type*/String perativeParamType, Integer ordering)
	{
		this.name = name;
		this.perativeParamType=perativeParamType;
//		this.type = type;
		this.ordering = ordering;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}

	@Column(name = "Name", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", nullable = false, length = 25)
//	@Enumerated(EnumType.STRING)
	public String getPerativeParamType() {
		return perativeParamType;
	}
	
	public void setPerativeParamType(String perativeParamType) {
		this.perativeParamType = perativeParamType;
	}
	
	/*
	 * public OperativeParamType getType() { return type; }
	 * 
	 * public void setType(OperativeParamType type) { this.type = type; }
	 */

	public Integer getOrdering() {
		return ordering;
	}


	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 * 
	 * @JoinColumn(name = "Tenant_Id", referencedColumnName = "Id") // @JSON(include
	 * = false)
	 * 
	 * @JsonIgnore public Tenant getTenant() { return tenant; }
	 * 
	 * public void setTenant(Tenant tenant) { this.tenant = tenant; }
	 */
	@Override
	public String toString() {
		return "Diagnosis [name=" + name + "]";
	}

	public boolean hasId() {
		return id != null && id > 0;
	}

}

