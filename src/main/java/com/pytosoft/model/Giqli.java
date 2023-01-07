package com.pytosoft.model;


import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import flexjson.JSON;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "giqli")
public class Giqli implements Serializable {

	private static final long serialVersionUID = 2644351190239779719L;

	public static final String GIQLI_PARAM_VALUE = "giqliParamValue";

	public static String MEDICAL_CASE = "medicalCase";

	public static final String ID = "id";

	public static final String CREATED_ON = "createdOn";

	private Long id;

	@Valid
	private List<GiqliParamValue> giqliParamValue;

	@Valid
	private MedicalCase medicalCase;


	private Date createdOn;

	public Giqli() {
	}

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "giqli")
	public List<GiqliParamValue> getGiqliParamValue() {
		return giqliParamValue;
	}

	public void setGiqliParamValue(List<GiqliParamValue> giqliParamValue) {
		this.giqliParamValue = giqliParamValue;
	}

	

	@Column(name = "Created_on", nullable = false)
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "Medical_Case_Id", referencedColumnName = "Id")
	public MedicalCase getMedicalCase() {
		return medicalCase;
	}

	public void setMedicalCase(MedicalCase medicalCase) {
		this.medicalCase = medicalCase;
	}

	
	public void sortGiqliParams() {
		Comparator<GiqliParamValue> comparator = new Comparator<GiqliParamValue>() {
			public int compare(GiqliParamValue o1, GiqliParamValue o2) {
				if (o1.getGiqliParam().getOrdering() == null) {
					return 0;
				}
				return o1.getGiqliParam().getOrdering().compareTo(o2.getGiqliParam().getOrdering());
			};
		};
		Collections.sort(giqliParamValue, comparator);
	}
}

