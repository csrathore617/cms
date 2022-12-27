package com.pytosoft.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "observed_complain")
public class ObservedComplain  {
	//private static final long serialVersionUID = 2760312952441468614L;

	public static final String COMPLAIN = "complain";

	public static final String ORDERING = "ordering";

	private Long id;

	private Complain complain;

	private String notes;

	private Integer ordering;

	@ManyToOne(optional = false)
	@JoinColumn(name = "Complain_Id", referencedColumnName = "Id")
	public Complain getComplain() {
		return complain;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long getId() {
		return id;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Notes", length = 500, nullable = true)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "Ordering", nullable = true)
	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
}
