package com.pytosoft.model;


import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import jakarta.persistence.CascadeType;
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
@Table(name = "giqli_param_value")
public class GiqliParamValue {

	public static String GIQLI_PARAM ="giqliParam";

	private Long id;

	private GiqliParam giqliParam;

	@Digits(message = "{giqli.value..digits}", fraction = 0, integer = 10)
	@Min(value=0 ,message = "{giqli.min.value}" )
	@Max(value=10 ,message = "{giqli.max.value}")
	private Integer value;

	private Giqli giqli;

	public GiqliParamValue() {
		super();
	}

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "Giqli_Param_Id", referencedColumnName = "Id")
	public GiqliParam getGiqliParam() {
		return giqliParam;
	}

	public void setGiqliParam(GiqliParam giqliParam) {
		this.giqliParam = giqliParam;
	}

	@Column(name = "Value")
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "Giqli_Id", referencedColumnName = "Id")
	public Giqli getGiqli() {
		return giqli;
	}
	

	public void setGiqli(Giqli giqli) {
		this.giqli = giqli;
	}
	
}
