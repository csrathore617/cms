package com.pytosoft.model.scheduling;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.pytosoft.util.JsonDateTimeDeserializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "booking_time_slot")
public class BookingTimeSlot
{
	
	private Long id;

	private Date start;

	private Date end;

	private DayOfWeek dayOfWeek;
	// by vikram 
	private DoctorClinicAssignment doctorClinicAssignment;

	private boolean active;

//	private boolean lock;

	// for ui only
//	private boolean booked;

	private String title;
	
	public BookingTimeSlot()
	{

	}

	public BookingTimeSlot(Date startTime, Date endTime)
	{
		this.start = startTime;
		this.end = endTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@Column(name = "Start_Time", nullable = false)
	public Date getStart()
	{
		return start;
	}

	@Column(name = "End_Time", nullable = false)
	public Date getEnd()
	{
		return end;
	}

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Day_Of_Week_Id", referencedColumnName = "Id")
	public DayOfWeek getDayOfWeek()
	{
		return dayOfWeek;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Doctor_Clinic_Assignment_Id", referencedColumnName = "Id")
	public DoctorClinicAssignment getDoctorClinicAssignment()
	{
		return doctorClinicAssignment;
	}

	public void setDoctorClinicAssignment(DoctorClinicAssignment doctorClinicAssignment)
	{
		this.doctorClinicAssignment = doctorClinicAssignment;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	public void setStart(Date start)
	{
		this.start = start;
	}

	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	public void setEnd(Date end)
	{
		this.end = end;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek)
	{
		this.dayOfWeek = dayOfWeek;
	}

	@Column(name = "Active", nullable = false)
	@Value("true")
	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	// for ui only

//	@Transient
//	public boolean isBooked()
//	{
//		return booked;
//	}
//
//	public void setBooked(boolean booked)
//	{
//		this.booked = booked;
//	}

	@Transient
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

//	@Column(name = "Lock_Field", nullable = true)
//	public boolean isLock()
//	{
//		return lock;
//	}
//
//	public void setLock(boolean lock)
//	{
//		this.lock = lock;
//	}

	

	

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj)
//	{
//		DateTimeComparator comparator = DateTimeComparator.getTimeOnlyInstance();
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BookingTimeSlot other = (BookingTimeSlot) obj;
//		if (dayOfWeek == null)
//		{
//			if (other.dayOfWeek != null)
//				return false;
//		} else if (!dayOfWeek.equals(other.dayOfWeek))
//			return false;
//		if (end == null)
//		{
//			if (other.end != null)
//				return false;
//
//		} else if (comparator.compare(end, other.end) != 0)
//			return false;
//		if (start == null)
//		{
//			if (other.start != null)
//				return false;
//		} else if (comparator.compare(start, other.start) != 0)
//			return false;
//		return true;
//	}

	@Override
	public String toString()
	{
		return "BookingTimeSlot [dayOfWeek=" + dayOfWeek + ", start=" + start + ", end=" + end + "]";
		// return "BookingTimeSlot [start=" + start + ", end=" + end +
		// ", dayOfWeek=" + dayOfWeek + "]";
	}
	
}
