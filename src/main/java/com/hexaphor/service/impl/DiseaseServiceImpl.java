package com.hexaphor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hexaphor.common.Command;
import com.hexaphor.model.Disease;
import com.hexaphor.repo.ClinicRepository;
import com.hexaphor.repo.DiseaseRepository;
import com.hexaphor.service.IDiseaseService;

@Service
public class DiseaseServiceImpl implements IDiseaseService {

	@Autowired
	private DiseaseRepository repo;
	@Autowired
	private ClinicRepository clRepo;
	
	@Autowired
	private Command code;
	
	//Save disease
	@Override
	public Disease saveDisease(Disease disease) throws Exception {

		disease.setDiseaseId(code.createNewTrackerId(7));
		disease=repo.save(disease);
		code.UpdatedTrackerID(7, disease.getDiseaseId());
		return disease;
	}

	@Override
	public List<Disease> listDisease(String clinicId) throws Exception {
		
		return repo.findAll().stream().filter(de->de.getClinicId()==clinicId).collect(Collectors.toList());
	}

	@Override
	public Disease updateDisease(Disease disease) throws Exception {
		
		return repo.save(disease);
	}

	@Override
	public Disease getDisease(String diseaseId) throws Exception {
		
		return repo.findById(diseaseId).get();
	}

	@Override
	public String removeDisease(String diseaseId) throws Exception {
		String response="fail";
		if(repo.existsById(diseaseId)) {
			repo.deleteById(diseaseId);
			response="success";
		}
		return response;
	}

	@Override
	public String removeDiseaseUsingClinicId(String clinicId) throws Exception {
		String response="fail";
		if(clRepo.existsById(clinicId)) {
			repo.deleteInBatch(repo.findAll().stream().filter(cl->cl.getClinicId()==clinicId).collect(Collectors.toList()));
			response="success";
		}
		
		return response;
	}

	@Override
	public Page<Disease> pageDisease(Pageable Pageable, String clinicId) throws Exception {
		
		return repo.findDiseaseByClinicId(clinicId,Pageable);
	}

}
