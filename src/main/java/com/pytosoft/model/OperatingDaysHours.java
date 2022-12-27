package com.pytosoft.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.pytosoft.constants.OperatingDays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "operating_days_hours")
public class OperatingDaysHours
{

	private Long id;

	@NotNull(message = "{availableFacility.facility.notNull}")
	@Valid
	private OperatingDays operatingDay;

	private String startTime;

	private String endTime;

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

	@Column(name = "Operating_Day", nullable = false)
	@Enumerated(EnumType.STRING)
	public OperatingDays getOperatingDay()
	{
		return operatingDay;
	}

	public void setOperatingDay(OperatingDays operatingDay)
	{
		this.operatingDay = operatingDay;
	}

	@Column(name = "Start_Time", nullable = false)
	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	@Column(name = "End_Time", nullable = false)
	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

}
