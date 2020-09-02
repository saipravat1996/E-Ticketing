package com.hexaphor.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hexaphor.model.Scheduling;

public interface ISchedulingService {

	
	public Scheduling saveScheduling(Scheduling scheduing)throws Exception;
	
	public Page<Scheduling>  getPagingSchedulingByClinicId(Pageable pageable,String clinicId)throws Exception;
	
	public Scheduling updateScheling(Scheduling scheduing) throws Exception;
	
	public Scheduling getSchedulingBySchedulingId(String schdulingId)throws Exception;
	
	public List<Scheduling>  getAllSchedulingByClinicId(String clinicId)throws Exception;
	
	public String  removeSchedulingById(String schdulingId)throws Exception;
	
}
