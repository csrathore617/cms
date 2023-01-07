package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pytosoft.model.Referral;

public interface ReferralRepository extends JpaRepository<Referral, Long> {

}
