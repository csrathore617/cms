package com.pytosoft.model;


import java.util.Comparator;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "giqli")
public class Giqli  {

	private Long id;

	private Date createdOn;

	public Giqli() {
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

	public void sortGiqliParams() {
		Comparator<GiqliParamValue> comparator = new Comparator<GiqliParamValue>() {
			public int compare(GiqliParamValue o1, GiqliParamValue o2) {
				if (o1.getGiqliParam().getOrdering() == null) {
					return 0;
				}
				return o1.getGiqliParam().getOrdering().compareTo(o2.getGiqliParam().getOrdering());
			};
		};
		
	}
}
