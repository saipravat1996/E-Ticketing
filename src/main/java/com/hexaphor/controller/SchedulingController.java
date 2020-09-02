package com.hexaphor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaphor.model.Scheduling;
import com.hexaphor.model.Slot;
import com.hexaphor.service.ISchedulingService;

/**
 * 
 * @author saipr
 *
 */
@RestController
@RequestMapping("/rest/scheduling")
public class SchedulingController {
	
	@Autowired
	private ISchedulingService service;
	/**
	 * 
	 * @param scheduing
	 * @param listSlot
	 * @return
	 */
	//Create Scheduling
	@PostMapping("/create")
    public ResponseEntity<String> saveSheduling(Scheduling scheduing){
    	ResponseEntity<String> responseEntity=null;
    	try {
    		//Save scheduling
    		scheduing=service.saveScheduling(scheduing);
    		responseEntity=new ResponseEntity<String>("Successful created scheduling", HttpStatus.OK);
    	}
    	catch (Exception e) {
    		responseEntity=new ResponseEntity<String>("Unsuccsessful created scheduling", HttpStatus.BAD_REQUEST);
    		e.printStackTrace();
		}
    	return responseEntity;
    }
	//Update Scheduling
		@PutMapping("/update")
	    public ResponseEntity<String> updateSheduling(Scheduling scheduing,@RequestBody List<Slot> listSlot){
	    	ResponseEntity<String> responseEntity=null;
	    	try {
	    		//update scheduling
	    		scheduing=service.updateScheling(scheduing);
	    		responseEntity=new ResponseEntity<String>("Successful updated scheduling", HttpStatus.OK);
	    	}
	    	catch (Exception e) {
	    		responseEntity=new ResponseEntity<String>("Unsuccsessful updated scheduling", HttpStatus.BAD_REQUEST);
	    		e.printStackTrace();
			}
	    	return responseEntity;
	    }
	/**
	 * 	
	 * @param schedulingId
	 * @return
	 */
    //Get Scheduling By Scheduling ID
	@GetMapping("/byId")
	 public ResponseEntity<?> getShedulingById(@PathVariable String schedulingId ){
	    	ResponseEntity<?> responseEntity=null;
	    	try {
	    		//Get scheduling
	    		responseEntity=new ResponseEntity<Scheduling>(service.getSchedulingBySchedulingId(schedulingId), HttpStatus.OK);
	    	}
	    	catch (Exception e) {
	    		responseEntity=new ResponseEntity<String>("Unsuccsessful created scheduling", HttpStatus.BAD_REQUEST);
	    		e.printStackTrace();
			}
	    	return responseEntity;
	    } 
	/**
	 * 
	 * @param pageable
	 * @param clinicId
	 * @return
	 */
		//Get Paging Scheduling 
		@GetMapping("/page")
		 public ResponseEntity<?> getPagigantionShedulingByClinicId(@PageableDefault(page=0,size=10)Pageable pageable,@PathVariable String clinicId ){
		    	ResponseEntity<?> responseEntity=null;
		    	try {
		    		//Get page
		    		responseEntity=new ResponseEntity<Page<Scheduling>>(service.getPagingSchedulingByClinicId(pageable, clinicId),HttpStatus.OK);

		    	}
		    	catch (Exception e) {
		    		responseEntity=new ResponseEntity<String>("Unsuccsessful created scheduling", HttpStatus.BAD_REQUEST);
		    		e.printStackTrace();
				}
		    	return responseEntity;
		    } 
		
		/**
		 * 
		 * @param clinicId
		 * @return
		 */
				//Get All Scheduling By ClinicId
				@GetMapping("/all")
				 public ResponseEntity<?> getSchuingByClinicId(@PathVariable String clinicId ){
				    	ResponseEntity<?> responseEntity=null;
				    	try {
				    		//Get page
				    		responseEntity=new ResponseEntity<List<Scheduling>>(service.getAllSchedulingByClinicId(clinicId),HttpStatus.OK);

				    	}
				    	catch (Exception e) {
				    		responseEntity=new ResponseEntity<String>("Not Found scheduling", HttpStatus.BAD_REQUEST);
				    		e.printStackTrace();
						}
				    	return responseEntity;
				    } 
			/**
			 * 	
			 * @param schedulingId
			 * @return
			 */
				
				//Get All Scheduling By ClinicId
				@GetMapping("/remove")
				 public ResponseEntity<String> removeSchedule(@PathVariable String schedulingId ){
				    	ResponseEntity<String> responseEntity=null;
				    	try {
				    		//Get page
				    		responseEntity=new ResponseEntity<String>(service.removeSchedulingById(schedulingId),HttpStatus.OK);

				    	}
				    	catch (Exception e) {
				    		responseEntity=new ResponseEntity<String>("Server Error", HttpStatus.BAD_REQUEST);
				    		e.printStackTrace();
						}
				    	return responseEntity;
				    } 
    
    
    
    
}
