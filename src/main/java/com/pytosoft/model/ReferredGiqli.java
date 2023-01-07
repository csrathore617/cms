package com.pytosoft.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
@Table(name = "referred_giqli")
public class ReferredGiqli
{

	public static final String ID = "id";

	public static final String GIQLI = "giqli";

	public static final String REFERRAL = "referral";

	private Long id;

	@NotNull(message = "{referredGiqli.giqli.notNull}")
	@Valid
	private Giqli giqli;

//	private Referral referral;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "Giqli_Id", referencedColumnName = "Id")
	public Giqli getGiqli()
	{
		return giqli;
	}

	public void setGiqli(Giqli giqli)
	{
		this.giqli = giqli;
	}

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "Referral_Id", referencedColumnName = "Id", nullable = false)
//	public Referral getReferral()
//	{
//		return referral;
//	}
//
//	public void setReferral(Referral referral)
//	{
//		this.referral = referral;
//	}

}