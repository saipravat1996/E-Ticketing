package com.hexaphor.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hexaphor.model.Scheduing;

public interface ISchedulingService {

	
	public Scheduing saveScheduling(Scheduing scheduing)throws Exception;
	
	public Page<Scheduing>  getAllSchedulingByClinicId(Pageable pageable,String clinicId)throws Exception;
	
	public Scheduing updateScheling(Scheduing scheduing) throws Exception;
	
	public Scheduing getSchedulingBySchedulingId(String schdulingId)throws Exception;
	
	
	
}
