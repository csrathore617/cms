package com.pytosoft.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pytosoft.util.JsonDateDeserializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "surgical_history")
@FetchProfile(name = "fp_sh_surgicalProcedure", fetchOverrides = { @FetchProfile.FetchOverride(entity = SurgicalHistory.class, association = "surgicalProcedure", mode = FetchMode.JOIN) })
public class SurgicalHistory
{
	public static final String FP_SURGICAL_HISTORY_SURG_PROC = "fp_sh_surgicalProcedure";

	private Long id;

	@Past(message = "{surgicalHistory.surgeryDate.past}")
	private Date surgeryDate;

	@NotNull(message = "{surgicalHistory.surgicalProcedure.notNull}")
	@Valid
	private SurgicalProcedure surgicalProcedure;

	private Date createdOn;

	@Size(max = 160, message = "{surgicalHistory.comments.size}")
	//@NotHtml(message = "{surgicalHistory.comments.notHtml}")
	private String comments;

	@Column(name = "Created_On", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@Column(name = "Surgery_Date", nullable = true)
	public Date getSurgeryDate()
	{
		return surgeryDate;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Surgical_Procedure_Id", referencedColumnName = "Id")
	public SurgicalProcedure getSurgicalProcedure()
	{
		return surgicalProcedure;
	}

	@Column(name = "Comments", nullable = true, length = 100)
	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@JsonDeserialize(using = JsonDateDeserializer.class)
	public void setSurgeryDate(Date surgeryDate)
	{
		this.surgeryDate = surgeryDate;
	}

	public void setSurgicalProcedure(SurgicalProcedure surgicalProcedure)
	{
		this.surgicalProcedure = surgicalProcedure;
	}

}
