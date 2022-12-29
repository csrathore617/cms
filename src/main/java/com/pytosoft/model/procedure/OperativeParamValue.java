package com.pytosoft.model.procedure;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pytosoft.constraint.CreateProcedure;

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
@Table(name = "operative_param_value")
@BatchSize(size = 20)
public class OperativeParamValue implements /* SingleTenantOwned, */ Comparable<OperativeParamValue> {
	private static final long serialVersionUID = 3677985084623366300L;

	public static final String VALUE = "value";

	public static final String OPERATIVE_PARAMS = "operativeParam";

	public static final String ID = "id";

	private Long id;

//	@NotHtml(groups = { CreateProcedure.class }, message = "{capturedOperativeParams.value.notHtml}")
	@Size(groups = { CreateProcedure.class }, max = 500, message = "{capturedOperativeParams.value.size}")
	private String value;

	@Valid
	private OperativeParam operativeParam;

//	private Procedure procedure;

//	private Tenant tenant;

	public OperativeParamValue() {

	}

	public OperativeParamValue(Long id) {
		this.id = id;
	}

	public OperativeParamValue(String value, OperativeParam operativeParam) {
		this.value = value;
		this.operativeParam = operativeParam;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "value", length = 255, nullable = false)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 * 
	 * @JoinColumn(name = "Tenant_Id", referencedColumnName = "Id")
	 * 
	 * @JSON(include = false)
	 * 
	 * @JsonIgnore public Tenant getTenant() { return tenant; }
	 * 
	 * public void setTenant(Tenant tenant) { this.tenant = tenant; }
	 */

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Operative_Param_Id", referencedColumnName = "Id")
	public OperativeParam getOperativeParam() {
		return operativeParam;
	}

	public void setOperativeParam(OperativeParam operativeParam) {
		this.operativeParam = operativeParam;
	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "Procedure_Id", referencedColumnName = "Id")
//	public Procedure getProcedure() {
//		return procedure;
//	}
//
//	public void setProcedure(Procedure procedure) {
//		this.procedure = procedure;
//	}

	public boolean hasId() {
		return id != null && id > 0;
	}

	@Override
	public int compareTo(OperativeParamValue o) {
		return (this.getOperativeParam().getId().compareTo(o.getOperativeParam().getId()));
	}

}
