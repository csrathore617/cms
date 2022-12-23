package com.pytosoft.model;



import org.hibernate.annotations.BatchSize;




import jakarta.persistence.*;

@Entity
@Table(name = "diagnosis")
@BatchSize(size = 20)
public class Diagnosis 
{
	public static final String NAME = "name";

	public static final String ID = "id";

	private Integer id;

	private String name;


	public Diagnosis()
	{

	}

	public Diagnosis(Integer id)
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

	@Column(name = "Name", length = 255, nullable = false)
	public String getName()
	{
		return name;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	

	

	@Override
	public String toString()
	{
		return "Diagnosis [name=" + name + "]";
	}

	public boolean hasId()
	{
		return id != null && id > 0;
	}

}
