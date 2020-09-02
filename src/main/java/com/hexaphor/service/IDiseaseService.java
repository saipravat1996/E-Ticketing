package com.hexaphor.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hexaphor.model.Disease;

public interface IDiseaseService {

	public Disease saveDisease(Disease disease) throws Exception;
	 
	public List<Disease> listDisease(String clinicId)throws Exception;
	
	public Disease updateDisease(Disease disease) throws Exception;
	
	public Disease getDisease(String diseaseId)throws Exception;
	
	public String removeDisease(String diseaseId)throws Exception;
	
	public String removeDiseaseUsingClinicId(String clinicId) throws Exception;
	
	public Page<Disease> pageDisease(Pageable Pageable,String clinicId)throws Exception;
	
}
