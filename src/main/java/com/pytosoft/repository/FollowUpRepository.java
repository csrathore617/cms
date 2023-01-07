package com.pytosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pytosoft.model.Doctor;
import com.pytosoft.model.FollowUp;
@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp, Long> {
	
	public List<FollowUp> findByFollowedByDoctor(Doctor followedByDoctor);

}
