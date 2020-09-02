package com.hexaphor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaphor.model.Doctor;
import com.hexaphor.service.IDoctorService;

@RestController
@RequestMapping("/rest/doctor")
public class DoctorController {

	//Logger logger = (Logger) LoggerFactory.getLogger(Doctor_Controller.class);
	
	@Autowired
	private IDoctorService doctor_Service;
	
	@PostMapping("/doctorSave")
	public ResponseEntity<String> Doctor_Registration(@RequestBody Doctor doctor){
		ResponseEntity<String> response=null;

		try{
			doctor=doctor_Service.doctor_RegistrationOrUpdate(doctor);
			response=new ResponseEntity<>("Doctor Registration Success",HttpStatus.OK);
			//logger.info("Doctor Registration Success");
		}
		catch(Exception e){
			response=new ResponseEntity<>("Doctor Unsuccess Registration",HttpStatus.EXPECTATION_FAILED);
			//logger.error("Doctor Unsuccess Registration"+e.getMessage());
		}
		return response;
	}
	
	
	@PutMapping("/doctorUpdate")
	public ResponseEntity<String> Doctor_update(@RequestBody Doctor doctor){
		ResponseEntity<String> response=null;
		try{
			doctor=doctor_Service.doctor_RegistrationOrUpdate(doctor);
			response=new ResponseEntity<>("Doctor Update Success",HttpStatus.OK);
			//logger.info("Doctor Update Success");
		}
		catch(Exception e){
			response=new ResponseEntity<>("Doctor Unsuccess Update",HttpStatus.EXPECTATION_FAILED);
			//logger.error("Doctor Unsuccess Update"+e.getMessage());
		}
		return response;
	}
	
	//Get All Clinic 
		@GetMapping("/getDoctorByClinicID/{clinicID}")
		public ResponseEntity<?> getDoctorByClinicID(@PathVariable String clinicID){
			ResponseEntity<?> response=null;
			List<Doctor> list=null;
			
			try{
				list=doctor_Service.GetAllDoctorByClinicId(clinicID);
				response=new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
				//logger.info("Get All Doctor By clinic");
			}
			catch(Exception e){
				response=new ResponseEntity<String>("Doctor Not Found",HttpStatus.EXPECTATION_FAILED);
			//	logger.error(e.getMessage());
			}
			return response;
		}
		
				//Get All Clinic 
				@GetMapping("getAllDoctor")
				public ResponseEntity<?> getClinic(){
					ResponseEntity<?> response=null;
					List<Doctor> list=null;
					
					try{
						list=doctor_Service.GetAllDoctor();
						response=new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
					//	logger.info("Get All Clinic Details");
					}
					catch(Exception e){
						response=new ResponseEntity<String>("Doctor Not Found",HttpStatus.EXPECTATION_FAILED);
						//logger.error(e.getMessage());
					}
					return response;
				}
	
}
