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
@Table(name = "complain")
public class Complain /* implements SingleTenantOwned */ {

	private static final long serialVersionUID = 5040083610582590293L;

	public static final String NAME = "name";

	public static final String ID = "id";

	@Min(value = 1, message = "{complain.id.min}")
	private Integer id;

	@NotNull(groups = { CreateEntity.class }, message = "{complain.name.notNull}")
	@Size(groups = { CreateEntity.class }, max = 255, message = "{complain.name.size}")
//	@NotHtml(groups = { CreateEntity.class }, message = "{complain.name.notHtml}")
	private String name;

//	private Tenant tenant;

	public Complain() {

	}

	public Complain(Integer id) {
		super();
		this.id = id;
	}

	public Complain(final Integer id, final String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}

	@Column(name = "Name", nullable = false, length = 255)
	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
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

}
