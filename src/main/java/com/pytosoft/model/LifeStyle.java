package com.pytosoft.model;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pytosoft.constraint.CreateEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "life_style")
@BatchSize(size = 20)
public class LifeStyle {

	public static final String NAME = "name";

	public static final String ID = "id";

	public static final String LIFE_STYLE_OPTIONS = "lifeStyleOptions";

	public static final String ORDERING = "ordering";

	@Min(value = 1, message = "{lifeStyle.id.min}")
	@NotNull(message = "{lifeStyle.id.notNull}")
	private Integer id;

	@NotNull(groups = { CreateEntity.class }, message = "{lifeStyle.name.notNull}")
	@Size(groups = { CreateEntity.class }, max = 255, message = "{lifeStyle.name.size}")
	//@NotHtml(groups = { CreateEntity.class }, message = "{lifeStyle.name.notHtml}")
	private String name;
	
	private Set<LifeStyleOption> lifeStyleOptions;

	private Integer ordering;

	public LifeStyle()
	{

	}

	public LifeStyle(Integer id)
	{
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "LifeStyle_Id", nullable = false)
	public Set<LifeStyleOption> getLifeStyleOptions() {
		return lifeStyleOptions;
	}

	public void setLifeStyleOptions(Set<LifeStyleOption> lifeStyleOptions) {
		this.lifeStyleOptions = lifeStyleOptions;
	}

	@Column(name = "Ordering", nullable = true)
	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
	
	@Override
	public String toString()
	{
		return "Life Style [name=" + name + "]";
	}

	public boolean hasId()
	{
		return id != null && id > 0;
	}

}
