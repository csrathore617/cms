package com.pytosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pytosoft.model.Drug;
import com.pytosoft.repository.DrugRepository;





@Service
public class DrugService {
	@Autowired
	private DrugRepository drugRepository;
	
    public List<Drug> listAll() {
        return drugRepository.findAll();
    }
     
    public void save(Drug drug) {
        drugRepository.save(drug);
    }
     
    public Drug getById(Long id) {
        return drugRepository.findById(id).get();
    }
    
    public void delete(Long id) {
        drugRepository.deleteById(id);
    }
    
    public Drug update(Drug drug) {
    	drugRepository.findById(drug.getId());
        Drug drug_obj =new Drug();
    	drug_obj.setId(drug.getId());
    	drug_obj.setName(drug.getName());
    	drug_obj.setDrugClass(drug.getDrugClass());
    	drug_obj.setGenericName(drug.getGenericName());
    	drug_obj.setDrugForm(drug.getDrugForm());
    	drug_obj.setBrandName(drug.getBrandName());
    	drug_obj.setIsUserDefined(drug.getIsUserDefined());
        return drugRepository.save(drug_obj);    	
    }
}