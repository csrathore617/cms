package com.pytosoft.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "captured_life_style")
@BatchSize(size = 20)
public class CapturedLifeStyle {

	public static final String NAME = "name";
	
	public static final String ID = "id";

	public static final String LIFE_STYLE = "lifeStyle";

	private Long id;

	@Size(max = 100, message = "{capturedLifeStyle.notes.size}")
//	@NotHtml(message = "{capturedLifeStyle.notes.notHtml}")
	private String value;
	
	@NotNull(message = "{capturedLifeStyle.lifeStyle.notNull}")
	@Valid
	private LifeStyle lifeStyle;
	
	private Date createdOn;
	
	public CapturedLifeStyle()
	{

	}

	public CapturedLifeStyle(Long id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	
	@Column(name = "value", length = 255, nullable = false)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LifeStyle_Id", referencedColumnName = "Id")
	public LifeStyle getLifeStyle() {
		return lifeStyle;
	}

	public void setLifeStyle(LifeStyle lifeStyle) {
		this.lifeStyle = lifeStyle;
	}

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public boolean hasId()
	{
		return id != null && id > 0;
	}
}

