package com.pytosoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorite_medicine")
public class FavoriteMedicine {
	// private static final long serialVersionUID = 8514176275330620073L;

	public static final String MEDICINE = "medicines";

	public static final String ID = "id";

	public static final String NAME = "name";

	private Long id;

	private String name;

	public FavoriteMedicine() {

	}

	public FavoriteMedicine(Long id) {
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

	@Column(name = "Name", nullable = true, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
