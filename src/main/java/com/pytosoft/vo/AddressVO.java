package com.pytosoft.vo;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.pytosoft.constraint.Alpha;
import com.pytosoft.constraint.AlphaNumeric;
import com.pytosoft.constraint.NotHtml;
import com.pytosoft.model.Country;
import com.pytosoft.model.State;

public class AddressVO implements Serializable
{

	private static final long serialVersionUID = 5901070897194842313L;
	
	private static final String SPACE = " ";

	private Long id;

	@Size(max = 255, message = "{address.addressLine1.size}")
	@NotHtml(message = "{address.addressLine1.notHtml}")
	private String addressLine1;

	@Size(max = 255, message = "{address.addressLine2.size}")
	@NotHtml(message = "{address.addressLine2.notHtml}")
	private String addressLine2;

	@Size(max = 50, message = "{address.area.size}")
	@AlphaNumeric(message = "{address.area.alphaNumeric}")
	private String area;

	@Size(max = 50, message = "{address.city.size}")
	@Alpha(message = "{address.city.alpha}")
	private String city;

	@Valid
	private State state;

	@Valid
	private Country country;

	@Size(max = 6, min = 6, message = "{address.zipCode.digit}")
	@Digits(integer = 6, fraction = 0, message = "{address.zipCode.digit}")
	private String zipCode;

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public String getAddressLine2()
	{
		return addressLine2;
	}

	public String getCity()
	{
		return city;
	}

	public Country getCountry()
	{
		return country;
	}

	public Long getId()
	{
		return id;
	}

	public State getState()
	{
		return state;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setCountry(Country country)
	{
		this.country = country;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	@Override
	public String toString()
	{
		return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", area="
				+ area + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}

	public String toFormatedString()
	{
		StringBuilder builder = new StringBuilder("");
		if (addressLine1 != null)
		{
			builder.append(addressLine1);
		}
		if (addressLine2 != null)
		{
			builder.append(SPACE).append(addressLine2);
		}
		if (area != null)
		{
			builder.append(SPACE).append(area);
		}
		if (city != null)
		{
			builder.append(SPACE).append(city);
		}
		if (state != null)
		{
			builder.append(SPACE).append(state.getName());
		}
		return builder.toString();
	}

}
