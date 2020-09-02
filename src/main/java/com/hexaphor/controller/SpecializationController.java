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

import com.hexaphor.model.Specialization;
import com.hexaphor.service.ISpecializationService;

@RestController
@RequestMapping("/rest/specialization")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;
	
	//1. Save Disease
		@PostMapping("/save")
		public ResponseEntity<String> save(Specialization specialization){

			ResponseEntity<String> response=null;
			try {
				specialization=service.save(specialization);
				response=new ResponseEntity<>("Successful save specialization.",HttpStatus.CREATED);

			}
			catch (Exception e) {
				response=new ResponseEntity<>("Successful save specialization.",HttpStatus.CREATED);
				e.printStackTrace();
			}
			return response;
		}
		//2. update Disease
			@PutMapping("/update")
			public ResponseEntity<String> updateSpecialization(Specialization specialization){

				ResponseEntity<String> response=null;
				try {
					specialization=service.updateSpecialization(specialization);
					response=new ResponseEntity<>("Successful update specialization.",HttpStatus.CREATED);

				}
				catch (Exception e) {
					response=new ResponseEntity<>("Successful update specialization.",HttpStatus.CREATED);
					e.printStackTrace();
				}
				return response;
			}
			
			
			//3. get specialization ById
			@GetMapping("/byId")
			public ResponseEntity<?> getSpecializationById(String specializationId){

			  ResponseEntity<?> response=null;
			  try {
					response=new ResponseEntity<Specialization>(service.getSpecialization(specializationId),HttpStatus.OK);

				  }
			  catch (Exception e) {
				response=new ResponseEntity<String>("Not Found specialization.",HttpStatus.BAD_REQUEST);
				e.printStackTrace();
				   }
				return response;
			}
			
			//4. get specialization By ClinicId
					@GetMapping("/byClinicId")
					public ResponseEntity<?> getSpecializationByClinicId(String clinicId){

					  ResponseEntity<?> response=null;
					  try {
							response=new ResponseEntity<List<Specialization>>(service.listSpecialization(clinicId),HttpStatus.OK);

						  }
					  catch (Exception e) {
						response=new ResponseEntity<String>("Not Found specialization.",HttpStatus.BAD_REQUEST);
						e.printStackTrace();
						   }
						return response;
					}
					
		//5. remove specialization ById
		@GetMapping("/removeById")
		public ResponseEntity<?> removeSpecializationById(String specializationId){

		ResponseEntity<?> response=null;
		try {
		response=new ResponseEntity<String>(service.removeSpecialization(specializationId),HttpStatus.OK);

		 }
		catch (Exception e) {
		response=new ResponseEntity<String>("Not Found Specialization.",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		   }
		return response;
		}
		//6. remove specialization By clinicId
			@GetMapping("/removeByClinicId")
			public ResponseEntity<?> removeSpecializationByClinicId(String clinicId){

			ResponseEntity<?> response=null;
			try {
			response=new ResponseEntity<String>(service.removeSpecializationUsingClinicId(clinicId),HttpStatus.OK);

			 }
			catch (Exception e) {
			response=new ResponseEntity<String>("Not Found specialization.",HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			   }
			return response;
			}

			//7. page  Specialization by Clinic Id
			@GetMapping("/pageByclinicId")
			public ResponseEntity<?> pageSpecializationByClinicId(@PageableDefault(page=0,size=10)Pageable pageable,String clinicId){

			ResponseEntity<?> response=null;
			try {
			response=new ResponseEntity<Page<Specialization>>(service.pageSpecialization(pageable, clinicId),HttpStatus.OK);

			 }
			catch (Exception e) {
			response=new ResponseEntity<String>("Not Found Specialization.",HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			   }
			return response;
			}
}
