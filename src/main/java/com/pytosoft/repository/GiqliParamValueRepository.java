package com.pytosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pytosoft.model.GiqliParamValue;
@Repository
public interface GiqliParamValueRepository extends JpaRepository<GiqliParamValue, Long> {

}
