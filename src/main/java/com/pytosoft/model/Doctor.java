package com.pytosoft.model;

<<<<<<< HEAD
import java.util.Set;
=======
import org.springframework.beans.factory.annotation.Value;

>>>>>>> main
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.pytosoft.model.DegreePassed;



@Entity
@Table(name = "Doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 6021680194805719243L;

	public static final String ID = "id";

	public static final String FP_DOCTOR_DOC_SPEC = "fp_doctor_doc_spec";

	public static final String FP_DOCTOR_DEGREE_PASSED = "fp_doctor_degree_passed";

	public static final String FP_DOCTOR_EXPERTISE = "fp_doctor_expertise";

	public static final String FP_DOCTOR_INTERESTS = "fp_doctor_interests";

	public static final String DOCTORSPECIALIZATION = "doctorSpecializations";

	public static final String DEGREES_PASSED = "degreesPassed";

	public static final String FP_DOCTOR_EXP = "fp_doctor_exp";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name ="doctor_name")
	private String doctorName;

<<<<<<< HEAD
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Doctor_id", referencedColumnName = "id")

=======
	
	
	@Column(name ="doctor_specialization")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = DoctorSpecialization.class)
	@JoinColumn(name = "Doctor_id", referencedColumnName = "Id")
>>>>>>> main
	private Set<DoctorSpecialization> doctorSpecializations;

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
<<<<<<< HEAD
	@JoinColumn(name = "Doctor_id", referencedColumnName = "id")
   
=======
	@JoinColumn(name = "Doctor_id", referencedColumnName = "Id")
	@Column(name = "degrees_passed")
>>>>>>> main
	private Set<DegreePassed> degreesPassed;

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Doctor_Id", referencedColumnName = "Id", nullable = false)
	@Column(name = "experties")
	private Set<Expertise> expertises;

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Doctor_Id", referencedColumnName = "Id", nullable = false)
	@Column(name = "experiences")
	private Set<Experience> experiences;

	@Column(name = "accepts_new_patient")
	private boolean acceptsNewPatient;
	
	@Column(name = "available_for_home_visit")
	private boolean availableForHomeVisit;

	public Doctor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
	public Set<DoctorSpecialization> getDoctorSpecializations() {
		return doctorSpecializations;
	}

	public void setDoctorSpecializations(Set<DoctorSpecialization> doctorSpecializations) {
		this.doctorSpecializations = doctorSpecializations;
	}
	
	public Set<DegreePassed> getDegreesPassed() {
		return degreesPassed;
	}

	public void setDegreesPassed(Set<DegreePassed> degreesPassed) {
		this.degreesPassed = degreesPassed;
	}

	public boolean isAcceptsNewPatient() {
		return acceptsNewPatient;
	}

	public void setAcceptsNewPatient(boolean acceptsNewPatient) {
		this.acceptsNewPatient = acceptsNewPatient;
	}

	public Doctor(Long id, String doctorName, Set<DoctorSpecialization> doctorSpecializations,
			Set<DegreePassed> degreesPassed, boolean acceptsNewPatient) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.doctorSpecializations = doctorSpecializations;
		this.degreesPassed = degreesPassed;
		this.acceptsNewPatient = acceptsNewPatient;
	}

	public Doctor(String doctorName) {
		super();
		this.doctorName = doctorName;
	}
	
	public Set<Expertise> getExpertises() {
		return expertises;
	}

	public void setExpertises(Set<Expertise> expertises) {
		this.expertises = expertises;
	}
	
	public Set<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	public boolean isAvailableForHomeVisit() {
		return availableForHomeVisit;
	}

	public void setAvailableForHomeVisit(boolean availableForHomeVisit) {
		this.availableForHomeVisit = availableForHomeVisit;
	}

}