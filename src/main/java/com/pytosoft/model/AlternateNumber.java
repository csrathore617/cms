package com.pytosoft.model;

//import java.io.Serializable;

import jakarta.persistence.*;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

@Entity
@Table(name = "alternatenumber")
public class AlternateNumber 
{

	//private static final long serialVersionUID = 1138466566931589806L;

	private Integer id;
	

//	@Size(max = 11, min = 10, message = "{hospital.alternateNumber.size}")
//	@Pattern(regexp = "[0-9]+", message = "{hospital.alternateNumber.regex}")
	private String alternateNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	//@JoinColumn(name = "id")
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	

}

