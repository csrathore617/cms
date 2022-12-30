package com.pytosoft.model.billing;

import com.pytosoft.constants.ServiceType;
import com.pytosoft.model.Doctor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "billable_service")
public class BillableService {
	
	private Integer id;

	private String name;

	private float defaultPrice;

	private Doctor createdBy;

	private ServiceType serviceType;


//	private LabInvestigationTemplate labInvestigation;

	public BillableService()
	{
	}

	public BillableService(Integer id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 255)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "Default_Price", nullable = true)
	public float getDefaultPrice()
	{
		return defaultPrice;
	}

	public void setDefaultPrice(float defaultPrice)
	{
		this.defaultPrice = defaultPrice;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Created_By", referencedColumnName = "id")
	public Doctor getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(Doctor createdBy)
	{
		this.createdBy = createdBy;
	}

	@Column(name = "Service_Type", nullable = false, length = 25)
	@Enumerated(EnumType.STRING)
	public ServiceType getServiceType()
	{
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType)
	{
		this.serviceType = serviceType;
	}

	

//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "Lab_Investigation_Id", referencedColumnName = "Id", nullable = true)
//	public LabInvestigationTemplate getLabInvestigation()
//	{
//		return labInvestigation;
//	}
//
//	public void setLabInvestigation(LabInvestigationTemplate labInvestigation)
//	{
//		this.labInvestigation = labInvestigation;
//	}

}