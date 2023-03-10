package com.pytosoft.model;


import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_mode")
public class PaymentMode
{

	private Long id;

	//@NotBlank(message = "{paymentMode.mode.notBlank}")
	@Size(max = 50, message = "{paymentMode.mode.size}")
	private String mode;

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

	@Column(name = "Mode", length = 50, nullable = false)
	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
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
		PaymentMode other = (PaymentMode) obj;
		if (mode == null)
		{
			if (other.mode != null)
				return false;
		} else if (!mode.equals(other.mode))
			return false;
		return true;
	}

}

