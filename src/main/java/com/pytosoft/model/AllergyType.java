
package com.pytosoft.model;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "allergy_type")

public class AllergyType {

	@Min(value = 1, message = "{allergyType.id.min}")
	private Short id;

	private String name;

	public AllergyType() {
	}

	public AllergyType(Short id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Short getId() {
		return id;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
