package com.hexaphor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaphor.model.Disease;
import com.hexaphor.service.IDiseaseService;

@RestController
@RequestMapping("/rest/disease")
public class DiseaseController {

	//Logger 
	//private static Logger logger=Logger.getLogger(DiseaseController.class);

	@Autowired
	private IDiseaseService service;
	
	//1. Save Disease
	@PostMapping("/save")
	public ResponseEntity<String> saveDisease(Disease disease){

		ResponseEntity<String> response=null;
		try {
			disease=service.saveDisease(disease);
			response=new ResponseEntity<>("Successful save disease.",HttpStatus.CREATED);

		}
		catch (Exception e) {
			response=new ResponseEntity<>("Successful save disease.",HttpStatus.CREATED);
			e.printStackTrace();
		}
		return response;
	}
	//2. update Disease
		@PutMapping("/update")
		public ResponseEntity<String> updateDisease(Disease disease){

			ResponseEntity<String> response=null;
			try {
				disease=service.updateDisease(disease);
				response=new ResponseEntity<>("Successful update disease.",HttpStatus.CREATED);

			}
			catch (Exception e) {
				response=new ResponseEntity<>("Successful update disease.",HttpStatus.CREATED);
				e.printStackTrace();
			}
			return response;
		}
		
		
		//3. get Disease ById
		@GetMapping("/byId")
		public ResponseEntity<?> getDiseaseById(String diseaseId){

		  ResponseEntity<?> response=null;
		  try {
				response=new ResponseEntity<Disease>(service.getDisease(diseaseId),HttpStatus.OK);

			  }
		  catch (Exception e) {
			response=new ResponseEntity<String>("Not Found Disease.",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
			   }
			return response;
		}
		
		//4. get Disease By ClinicId
				@GetMapping("/byClinicId")
				public ResponseEntity<?> getDiseaseByClinicId(String clinicId){

				  ResponseEntity<?> response=null;
				  try {
						response=new ResponseEntity<List<Disease>>(service.listDisease(clinicId),HttpStatus.OK);

					  }
				  catch (Exception e) {
					response=new ResponseEntity<String>("Not Found Disease.",HttpStatus.BAD_REQUEST);
					e.printStackTrace();
					   }
					return response;
				}
				
	//5. remove Disease ById
	@GetMapping("/removeById")
	public ResponseEntity<?> removeDiseaseById(String diseaseId){

	ResponseEntity<?> response=null;
	try {
	response=new ResponseEntity<String>(service.removeDisease(diseaseId),HttpStatus.OK);

	 }
	catch (Exception e) {
	response=new ResponseEntity<String>("Not Found Disease.",HttpStatus.BAD_REQUEST);
		e.printStackTrace();
	   }
	return response;
	}
	//6. remove Disease By clinicId
		@GetMapping("/removeByClinicId")
		public ResponseEntity<?> removeDiseaseByClinicId(String clinicId){

		ResponseEntity<?> response=null;
		try {
		response=new ResponseEntity<String>(service.removeDiseaseUsingClinicId(clinicId),HttpStatus.OK);

		 }
		catch (Exception e) {
		response=new ResponseEntity<String>("Not Found Disease.",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		   }
		return response;
		}

		//7. page  Disease by Clinic Id
		@GetMapping("/pageByclinicId")
		public ResponseEntity<?> pageDiseaseByClinicId(@PageableDefault(page=0,size=10)Pageable pageable,String clinicId){

		ResponseEntity<?> response=null;
		try {
		response=new ResponseEntity<Page<Disease>>(service.pageDisease(pageable, clinicId),HttpStatus.OK);

		 }
		catch (Exception e) {
		response=new ResponseEntity<String>("Not Found Disease.",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		   }
		return response;
		}
}
