package com.hexaphor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaphor.Global.StaticData;
import com.hexaphor.model.LoginUser;
import com.hexaphor.service.ILoginService;
import com.hexaphor.service.IPatientService;

@RestController
@RequestMapping("/rest/login")
public class Login_Controller {
	
	@Autowired
	private ILoginService login_Service;
	@Autowired
	private IPatientService patient_Service;
	//Logger logger = (Logger) LoggerFactory.getLogger(Login_Controller.class);
	StaticData loginuser;
	@PostMapping("/userAuthentication")
	public ResponseEntity<String> login(@RequestBody LoginUser loginUser){
		ResponseEntity<String> response=null;
		try{
			LoginUser lu=login_Service.login(loginUser.getLoginName(), loginUser.getPassword());
			
			if(lu==null) {
				response=new ResponseEntity<String>("Provide Correct Authentication", HttpStatus.BAD_REQUEST);
				
			}
			else {
				if(lu.getRole().equals("Admin")){
					patient_Service.get_All_Patient_Registration();
					response=new ResponseEntity<String>("Admin Login Successful", HttpStatus.OK);
				}
				else if(lu.getRole().equals("Patient")){
					patient_Service.get_Patient_By_Id(loginUser.getLoginName());
					response=new ResponseEntity<String>("Patient Login Successful", HttpStatus.OK);
				}
				else if(lu.equals("Clinic")){
					response=new ResponseEntity<String>("Clinic Login Successful", HttpStatus.OK);
				}
				else {
					response=new ResponseEntity<String>("Provide Correct Authentication", HttpStatus.BAD_REQUEST);
				
				}
			}
			
		}
		catch(Exception e){
			response=new ResponseEntity<String>("Http Not Supported", HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
			
		}
		
		return response;
	}
	
	@GetMapping("forgetpassword")
	public String forgetPassword(@RequestParam String userName,@RequestParam String gmail){
		 String result=null;
		  try{
			  result=  login_Service.forgetPassword(userName, gmail);
			  if(result.equals("your password send to mail")){
				  return "Your Password Send to your registared email ID ";
			  }
			  else if(result.equals("Enter Correct Email ID and User Name")){
				  return "Enter Correct Email ID and User Name";
			  }
			  else{
				  return "Enter Correct  User Name"; 
			  }
		  }
		  catch(Exception e){
			  return "Enter Correct  User Name";
		  }
		
	}

}
