package com.hexaphor.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexaphor.Global.StaticData;
import com.hexaphor.common.Command;
import com.hexaphor.model.LoginUser;
import com.hexaphor.model.Patient;
import com.hexaphor.model.Status;
import com.hexaphor.repository.LoginUserRepository;
import com.hexaphor.repository.PatientRepository;
import com.hexaphor.service.IPatientService;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {
	//Logger logger = (Logger) LoggerFactory.getLogger(PatientServiceImpl.class);
	@Autowired
	private PatientRepository patient_Reg_Repository;
	@Autowired
	private LoginUserRepository login_User_Repository;
	@Autowired
	private Command code;
	List<Status> listStatus=StaticData.AllStatusDetails;
	
	@Override
	public Patient Patient_Registration(Patient patient) throws Exception {
		//logger.info(this.getClass()+" :Patient_Registration start");
	

		LoginUser login_User=null;

		String Tracking_ID=null;
		Integer statusId=code.getStatusID(patient.getUiStatus());

		//create patient_Reg object and Login_User Object

		login_User=new LoginUser();
		
		//copy object data

		BeanUtils.copyProperties(patient, login_User);
		
		//Insert Login User Data Logic
		Tracking_ID=code.createNewTrackerId(6);

		login_User.setLoginID(Tracking_ID);
		
		login_User.setRole("RL2");
		
		login_User=login_User_Repository.save(login_User);
		
		code.UpdatedTrackerID(6,Tracking_ID);
		
		//logger.info(this.getClass()+" :Login User Inserted sucessful");
		

		Tracking_ID=code.createNewTrackerId(5);
		
		patient.setPatientId(Tracking_ID);
		patient.setLoginID(login_User.getLoginID());

		patient.setStatus(statusId);
		
		patient=patient_Reg_Repository.save(patient);
		
		code.UpdatedTrackerID(5, Tracking_ID);
		
		//logger.info(this.getClass()+" :patient_Registration Inserted sucessful");
		
		return patient;
	}

	@Override
	public List<Patient> get_All_Patient_Registration() throws Exception {
		//logger.info(this.getClass()+" :get_All_Patient_Registration start");
		List<Patient> listPatient=null;


		
		listPatient=patient_Reg_Repository.findAll();
		
		List<LoginUser> loginUser=login_User_Repository.findAll();
		for (LoginUser login_User : loginUser) {
	
			StaticData.GetAllLoginUser.add(login_User);
		}
		//logger.info(this.getClass()+" :get_All_Patient_Registration end");
		return listPatient;
	}

	@Override
	public Patient get_Patient_By_Id(String patientID) throws Exception {

		return patient_Reg_Repository.findById(patientID).get();
	}

}
