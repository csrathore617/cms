package com.pytosoft.vo;

import java.util.Date;

public class DoctorTimingByClinicVO
{

	private String startDay;

	private String lastDay;

	private Date minDate;

	private Date maxDate;

	public String getStartDay()
	{
		return startDay;
	}

	public void setStartDay(String startDay)
	{
		this.startDay = startDay;
	}

	public String getLastDay()
	{
		return lastDay;
	}

	public void setLastDay(String lastDay)
	{
		this.lastDay = lastDay;
	}

	public Date getMinDate()
	{
		return minDate;
	}

	public void setMinDate(Date minDate)
	{
		this.minDate = minDate;
	}

	public Date getMaxDate()
	{
		return maxDate;
	}

	public void setMaxDate(Date maxDate)
	{
		this.maxDate = maxDate;
	}

}

