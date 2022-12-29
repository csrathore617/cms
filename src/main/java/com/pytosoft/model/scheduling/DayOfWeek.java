package com.pytosoft.model.scheduling;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "day_of_week")
public class DayOfWeek
{

	public static final String NUMERIC_ID = "numericId";
	public static final String DAY = "name";

	private Byte id;

	private int numericId;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Byte getId()
	{
		return id;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName()
	{
		return name;
	}

	public void setId(Byte id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "Numeric_Id")
	public int getNumericId()
	{
		return numericId;
	}

	public void setNumericId(int numericId)
	{
		this.numericId = numericId;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numericId;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DayOfWeek other = (DayOfWeek) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numericId != other.numericId)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "DayOfWeek [name=" + name + "]";
	}

}
