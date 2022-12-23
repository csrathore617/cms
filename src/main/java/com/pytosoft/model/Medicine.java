package com.pytosoft.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;

@Entity
@Table(name = "medicine")
//@FetchProfile(name = "fp_medicine_drug", fetchOverrides = { @FetchProfile.FetchOverride(entity = Medicine.class, association = "drug", mode = FetchMode.JOIN) })
public class Medicine /* implements SingleTenantOwned */ {
	// private static final long serialVersionUID = 1504890907141434278L;

	public static final String FP_MEDICINE_DRUG = "fp_medicine_drug";

	public static final String DRUG = "drug";

	public static final String ID = "id";

	public static final String FAVORITE_MEDICINE = "favoriteMedicine";

	/*
	 * @NotNull(message = "{medicine.id.notNull}")
	 * 
	 * @Min(value = 1, message = "{medicine.id.min}")
	 */
	private Long id;

	/*
	 * @NotNull(groups = { CreateEntity.class }, message =
	 * "{medicine.drug.notNull}")
	 * 
	 * @Valid()
	 */
	private Drug drug;

	/*
	 * @Min(groups = { CreateEntity.class }, value = 1, message =
	 * "{medicine.duration.min}")
	 * 
	 * @Max(groups = { CreateEntity.class }, value = 365, message =
	 * "{medicine.duration.max}")
	 */
	private short duration;

	/*
	 * @NotBlank(groups = { CreateEntity.class }, message =
	 * "{medicine.instruction.notBlank}")
	 * 
	 * @Size(max = 255, min = 10, message = "{medicine.instruction.size}")
	 */
	private String instruction;
	/*
	 * @NotBlank(groups = { CreateEntity.class }, message =
	 * "{medicine.frequency.notBlank}")
	 * 
	 * @Size(max = 50, message = "{medicine.frequency.size}")
	 */
	private String frequency;

	private String strength;

	private String durationType;

//	private FavoriteMedicine favoriteMedicine;

//	private Tenant tenant;

	public Medicine() {

	}

	public Medicine(Long id) {
		super();
		this.id = id;
	}

	public Medicine(Long id, Drug drug, short duration) {
		super();
		this.id = id;
		this.drug = drug;
		this.duration = duration;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId() {
		return id;
	}

	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Drug_Id", referencedColumnName = "Id", nullable = true)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 10)
	// @NotFound(action = NotFoundAction.IGNORE)
	public Drug getDrug() {
		return drug;
	}

	@Column(name = "Duration")
	public short getDuration() {
		return duration;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Instruction", nullable = true)
	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Column(name = "Frequency", nullable = true)
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	@Column(name = "strength", length = 100, nullable = true)
	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	@Column(name = "duration_type", nullable = true)
	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	/*
	 * @ManyToOne(optional = false)
	 * 
	 * @JoinColumn(name = "favorite_medicine_Id", referencedColumnName = "Id")
	 * public FavoriteMedicine getFavoriteMedicine() { return favoriteMedicine; }
	 */
	/*
	 * public void setFavoriteMedicine(FavoriteMedicine favoriteMedicine) {
	 * this.favoriteMedicine = favoriteMedicine; }
	 */

	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = true)
	 * 
	 * @JoinColumn(name = "Tenant_Id", referencedColumnName = "Id") // @JSON(include
	 * = false)
	 * 
	 * @JsonIgnore public Tenant getTenant() { return tenant; }
	 * 
	 * public void setTenant(Tenant tenant) { this.tenant = tenant; }
	 */
}
