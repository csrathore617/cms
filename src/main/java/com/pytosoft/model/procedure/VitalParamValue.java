package com.pytosoft.model.procedure;

import javax.validation.Valid;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.pytosoft.constraint.CreateProcedure;
import com.pytosoft.constraint.CreateVisit;

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
@Table(name = "vital_param_value")
@BatchSize(size = 20)
public class VitalParamValue implements /* SingleTenantOwned , */Comparable<VitalParamValue>
 {
	private static final long serialVersionUID = 3677985084623366300L;

	public static final String VITAL = "vital";

	public static final String ID = "id";

	private Long id;

	@Digits(groups = { CreateProcedure.class, CreateVisit.class,
			Default.class }, integer = 6, fraction = 3, message = "{vitalParamValue.value.digits}")
	private String value;

	@Valid
	private Vital vital;

//	private Tenant tenant;

	public VitalParamValue() {

	}

	public VitalParamValue(Long id) {
		super();
		this.id = id;
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

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Tenant_Id", referencedColumnName = "Id")
//	@JSON(include = false)
//	@JsonIgnore
//	public Tenant getTenant() {
//		return tenant;
//	}
//
//	public void setTenant(Tenant tenant) {
//		this.tenant = tenant;
//	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Vital_Id", referencedColumnName = "Id")
	public Vital getVital() {
		return vital;
	}

	public void setVital(Vital vital) {
		this.vital = vital;
	}

	public boolean hasId() {
		return id != null && id > 0;
	}

	@Override
	public int compareTo(VitalParamValue o) {
		return (this.getVital().getId().compareTo(o.getVital().getId()));
	}
}

