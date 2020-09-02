package com.hexaphor.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaphor.model.Clinic;
import com.hexaphor.service.IClinicService;

@RestController
@RequestMapping("/rest/clinic")
public class ClinicController {
	
	private static Logger logger=Logger.getLogger(ClinicController.class);
	@Autowired
	private IClinicService clinic_Service;
	
	@PostMapping("clinicSave")
	public ResponseEntity<String> clinic_registration(@RequestBody Clinic clinic){
		ResponseEntity<String> response=null;
		try{
			clinic=clinic_Service.Registration(clinic);
			
			response=new ResponseEntity<>("Clinic Registration Success",HttpStatus.CREATED);
			
			logger.info("Clinic Registration Success");
		}
		catch(Exception e){
			response=new ResponseEntity<>("Clinic Unsuccess Registration",HttpStatus.EXPECTATION_FAILED);
			logger.error("Clinic Unsuccess Registration"+e.getMessage());
		}
		return response;
	}
	
	@PostMapping("clinicUpdate")
	public ResponseEntity<String> clinic_update(@RequestBody Clinic clinic){
		ResponseEntity<String> response=null;
		try{
			clinic=clinic_Service.Update(clinic);
			response=new ResponseEntity<>("Clinic Update Success",HttpStatus.OK);
			//logger.info("Clinic Update Success");
		}
		catch(Exception e){
			response=new ResponseEntity<>("Clinic Unsuccess Update",HttpStatus.EXPECTATION_FAILED);
			//logger.error("Clinic Unsuccess Update"+e.getMessage());
		}
		return response;
	}
	
	
	//Get All Clinic 
	@GetMapping("getAllClinic")
	public ResponseEntity<?> getClinic(){
		ResponseEntity<?> response=null;
		List<Clinic> list=null;
		
		try{
			list=clinic_Service.listClinic();
			response=new ResponseEntity<List<Clinic>>(list,HttpStatus.OK);
			//logger.info("Get All Clinic Details");
		}
		catch(Exception e){
			response=new ResponseEntity<String>("Not Found Data",HttpStatus.EXPECTATION_FAILED);
			//logger.error(e.getMessage());
		}
		return response;
	}
	
	
	@GetMapping("/getClinicByID/{clinicID}")
	public ResponseEntity<?> getClinicByID(@PathVariable String clinicID){
		ResponseEntity<?> response=null;
		Clinic clinic=null;
		
		try{
		    clinic=clinic_Service.getClinicDetails(clinicID);
			response=new ResponseEntity<Clinic>(clinic,HttpStatus.OK);
			//logger.info("Clinic Details");
		}
		catch(Exception e){
			response=new ResponseEntity<String>("Clinic Not Found",HttpStatus.EXPECTATION_FAILED);
		//	logger.error(e.getMessage());
		}
		return response;
	}
	
	//Remove Clinic 
	
	@DeleteMapping("/getClinicRemoveByID/{clinicID}")
	public ResponseEntity<String> getClinicRemoveByID(@PathVariable String clinicID){
		ResponseEntity<String> response=null;
	
		
		try{
		    clinic_Service.RemoveClinic(clinicID);
			response=new ResponseEntity<>("remove success clinic",HttpStatus.OK);
		//	logger.info("Remove  Clinic ");
		}
		catch(Exception e){
			response=new ResponseEntity<>("remove unsuccess clinic",HttpStatus.EXPECTATION_FAILED);
			//logger.error(e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/clinicName")
	public ResponseEntity<String>  validateName(
		@RequestParam String clinicName
		) 
	{
		ResponseEntity<String> response=null;
	  try {
		  
	  
	  int count=clinic_Service.countClinicName(clinicName);
	  if(count>0) {
		
		 response=new ResponseEntity<String>(clinicName + " Already Exist", HttpStatus.OK);
	  }
	  }
	  catch(Exception e) {
		  response=new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
	  }
	  return response;
	}
	
	//Check Clinic EmailID
	@GetMapping("/clinicEmail")
	public ResponseEntity<String>  validateEmail(
		@RequestParam String clinicEmail
		) 
	{
		ResponseEntity<String> response=null;
	 
	  try {
		  
	  
	  int count=clinic_Service.countClinicGmail(clinicEmail);
	  if(count>0) {
		  response=new ResponseEntity<String>(clinicEmail + " Already Exist", HttpStatus.OK);
		
	  }
	  }
	  catch(Exception e) {
		  response=new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
	  }
	  return response;
	}
	
	//Check Clinic Phone Number
	@GetMapping("/clinicPhoneNumber")
	public ResponseEntity<String> validatePhoneNumber(
		@RequestParam Long clinicPhoneNumber
		) 
	{
		ResponseEntity<String> response=null;
	  try {
		  
	  
	  int count=clinic_Service.countClinicPhoneNumber(clinicPhoneNumber);
	  if(count>0) {
		  response=new ResponseEntity<String>(clinicPhoneNumber + " Already Exist", HttpStatus.OK);
	
	  }
	  }
	  catch(Exception e) {
		  response=new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
	  }
	  return response;
	}

	//Check Clinic Phone Number
		@GetMapping("/loginName")
		public ResponseEntity<String> validateLoginName(
			@RequestParam String loginName
			) 
		{
			ResponseEntity<String> response=null;
		  try {
			  
		  
		  int count=clinic_Service.countLoginName(loginName);
		  if(count>0) {
			  response=new ResponseEntity<String>(loginName + " Already Exist", HttpStatus.OK);
		
		  }
		  }
		  catch(Exception e) {
			  response=new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		  }
		  return response;
		}
}
