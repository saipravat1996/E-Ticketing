package com.hexaphor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaphor.model.Patient;
import com.hexaphor.service.IPatientService;

@RestController
@RequestMapping("/rest/Patient")
public class PatientController {
	
	@Autowired
	private IPatientService Patient_Service;
	
	//Logger logger = (Logger) LoggerFactory.getLogger(Patient_Controller.class);
	@PostMapping("/patientSave")
public ResponseEntity<String>  patient_registration(@RequestBody Patient patient){
	
	//logger.info(this.getClass()+" :patient_registration start");
	try{
	Patient_Service.Patient_Registration(patient);
	//logger.info(this.getClass()+" :patient_registration Sucessfuled Registration");
	return new ResponseEntity<>("Sucessed",HttpStatus.OK);
	}
	catch(Exception e){
	//	logger.info(this.getClass()+" :patient_registration unsucessfuled Registration");
		return new ResponseEntity<>("UnSucessed",HttpStatus.EXPECTATION_FAILED);
	}
}
	
	
}
