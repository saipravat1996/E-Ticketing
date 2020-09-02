package com.hexaphor.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexaphor.Global.StaticData;
import com.hexaphor.common.Command;
import com.hexaphor.model.Clinic;
import com.hexaphor.model.LoginUser;
import com.hexaphor.model.Status;
import com.hexaphor.repo.ClinicRepository;
import com.hexaphor.repo.LoginUserRepository;
import com.hexaphor.service.IClinicService;

@Service
@Transactional
public class ClinicServiceImpl implements IClinicService {
//Logger logger = (Logger) LoggerFactory.getLogger(Clinic_Service_Impl.class);
	private static Logger logger=Logger.getLogger(ClinicServiceImpl.class);
	
	@Autowired
	Command code;
	@Autowired
	private ClinicRepository clinic_Repository;
	@Autowired
	private LoginUserRepository login_User_Repository;

	Clinic clinic_Details=StaticData.clinic_Details;
	List<Status> listStatus=StaticData.AllStatusDetails;
	
	@Override
	public Clinic Registration(Clinic clinic) throws Exception {


		LoginUser login_User=null;
		String Tracking_ID=null;
		
		Integer statusId=code.getStatusID(clinic.getUiStatus());
		

		login_User=new LoginUser();	
	    BeanUtils.copyProperties(clinic, login_User);
	    

	    	//Get TrackerID for Login Table 
	    	Tracking_ID=code.createNewTrackerId(6);
	    	
	    	login_User.setRole("RL1");
	    	login_User.setLoginID(Tracking_ID);
	    	
			login_User=login_User_Repository.save(login_User);
			
			//Updated Last Login TrackerID
			code.UpdatedTrackerID(6,Tracking_ID);
			
			logger.info(this.getClass()+" :Login User Inserted sucessful");
			
			//Create new Clinic TrackerID
			Tracking_ID=code.createNewTrackerId(1);
			clinic.setRole("RL1");
			clinic.setClinicID(Tracking_ID);
			clinic.setLoginID(login_User.getLoginID());
			
			clinic.setStatus(statusId);
			
			clinic.setCreatedBy("Hexaphor");
			
			java.util.Date date=new java.util.Date();
			clinic.setCreatedOn(new Date(date.getTime()));
			clinic.setUpdatedOn(new Date(date.getTime()));
			clinic=	clinic_Repository.save(clinic);
			
			code.UpdatedTrackerID(1, Tracking_ID);
			
			logger.info("Clinic Register Successful");


	    
		clinic.setUiStatus(code.getStatus(clinic.getStatus()));

		return clinic;
	}

	@Override
	public List<Clinic> listClinic() throws Exception {
		return clinic_Repository.findAll();
	}

	@Override
	public String RemoveClinic(String ClinicID) throws Exception {
		String responseBody=null;
		if(clinic_Repository.existsById(ClinicID)) {
			responseBody="Successful Delete";			
		}
		else {
			responseBody="unSuccessful Delete";
		}
		return responseBody;
	}

	@Override
	public Clinic getClinicDetails(String clinicID) throws Exception {
		Optional<Clinic> opt=null;
		 
		opt=clinic_Repository.findById(clinicID);
		
		Clinic clinic=opt.get();
		
		Optional<LoginUser> logopt=login_User_Repository.findById(clinic.getLoginID());
		
		LoginUser loginuser=logopt.get();
		
		BeanUtils.copyProperties(clinic, loginuser);
		
		//Set String Status value using statusID 
		clinic.setUiStatus(code.getStatus(clinic.getStatus()));
		
		logger.info("Get Clinic Details");
		
		return clinic;
	}



	@Override
	public Clinic Update(Clinic clinic) throws Exception {
		
		LoginUser login_User=null;
		
		Integer statusId=code.getStatusID(clinic.getUiStatus());

		login_User=new LoginUser();	
	    BeanUtils.copyProperties(clinic, login_User);

	    	login_User.setRole("RL3");
			login_User=login_User_Repository.save(login_User);
			
			logger.info(this.getClass()+" :Login User Updated sucessful");
			
			clinic.setLoginID(login_User.getLoginID());
			
			clinic.setStatus(statusId);
			
			clinic.setUpdatedBy("Hexaphor");
			
			java.util.Date date=new java.util.Date();
			clinic.setUpdatedOn(new Date(date.getTime()));
			
			clinic=	clinic_Repository.save(clinic);
			
			logger.info("Clinic Updated Successful");

			clinic.setUiStatus(code.getStatus(clinic.getStatus()));
			
			logger.info("Clinic Updated Successful");
			return clinic;
	}

	@Override
	public Integer countClinicGmail(String gmailID) throws Exception {
		
		return clinic_Repository.countGmailEmailId(gmailID);
	}

	@Override
	public Integer countClinicPhoneNumber(Long phoneNumber) throws Exception {
		
		return clinic_Repository.countClientPhoneNumber(phoneNumber);
	}

	//Check Client Name exist or not
	@Override
	public Integer countClinicName(String clinicName) throws Exception {
		
		return  clinic_Repository.countClientName(clinicName);
	}

	@Override
	public Integer countLoginName(String loginName) throws Exception {
		
		return login_User_Repository.countLoginName(loginName);
	}

}
