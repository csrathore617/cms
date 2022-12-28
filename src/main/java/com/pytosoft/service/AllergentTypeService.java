package com.pytosoft.service;

import java.util.List;

import com.pytosoft.model.AllergentType;

public interface AllergentTypeService {

	public List<AllergentType> getAllergentType();

	public void save(AllergentType allergentType);

	public AllergentType findById(Integer id);

	public void delete(AllergentType allergentType);
}
