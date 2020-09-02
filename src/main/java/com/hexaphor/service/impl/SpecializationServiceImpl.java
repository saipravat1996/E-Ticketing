package com.hexaphor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hexaphor.common.Command;
import com.hexaphor.model.Specialization;
import com.hexaphor.repo.ClinicRepository;
import com.hexaphor.repo.SpecializationRepo;
import com.hexaphor.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepo repo;
	@Autowired
	private ClinicRepository clRepo;
	@Autowired
	private Command code;
	@Override
	public Specialization save(Specialization specialization) throws Exception {
		specialization.setSpecializationId(code.createNewTrackerId(12));
		return repo.save(specialization);
	}

	@Override
	public List<Specialization> listSpecialization(String clinicId) throws Exception {
		return repo.findAll().stream().filter(cl->cl.getClinicId()==clinicId).collect(Collectors.toList());
	}

	@Override
	public Specialization updateSpecialization(Specialization specialization) throws Exception {
		
		return repo.save(specialization);
	}

	@Override
	public Specialization getSpecialization(String specializationId) throws Exception {
		
		return repo.findById(specializationId).get();
	}

	@Override
	public String removeSpecialization(String specializationId) throws Exception {
		String response="fail";
		if(repo.existsById(specializationId)) {
			repo.deleteById(specializationId);
			response="success";
		}
		return response;
	}

	@Override
	public String removeSpecializationUsingClinicId(String clinicId) throws Exception {
		String response="fail";
		if(clRepo.existsById(clinicId)) {
			
			repo.deleteInBatch(repo.findAll().stream().filter(cl->cl.getClinicId()==clinicId).collect(Collectors.toList()));
			response="success";
		}
		return response;
	}

	@Override
	public Page<Specialization> pageSpecialization(Pageable pageable, String clinicId) throws Exception {
		
		return repo.findSpecializationbyClinicId(clinicId, pageable);
	}

}
