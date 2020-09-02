package com.hexaphor.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hexaphor.model.Specialization;

public interface ISpecializationService {
	public Specialization save(Specialization specialization) throws Exception;
	 
	public List<Specialization> listSpecialization(String clinicId)throws Exception;
	
	public Specialization updateSpecialization(Specialization specialization) throws Exception;
	
	public Specialization getSpecialization(String specializationId)throws Exception;
	
	public String removeSpecialization(String specializationId)throws Exception;
	
	public String removeSpecializationUsingClinicId(String clinicId) throws Exception;
	
	public Page<Specialization> pageSpecialization(Pageable Pageable,String clinicId)throws Exception;
	
}
