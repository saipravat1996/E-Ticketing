package com.hexaphor.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexaphor.Global.StaticData;
import com.hexaphor.common.Command;
import com.hexaphor.model.Clinic;
import com.hexaphor.model.Doctor;
import com.hexaphor.model.Status;
import com.hexaphor.repo.DoctorRepository;
import com.hexaphor.service.IDoctorService;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {
	//Logger logger = (Logger) LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Autowired
	private Command code;
	@Autowired
	private DoctorRepository doctor_Repository;
	Clinic clinic_Details=StaticData.clinic_Details;
	List<Status> listStatus=StaticData.AllStatusDetails;
	
	@Override
	public Doctor doctor_RegistrationOrUpdate(Doctor doctor) throws Exception {

		//get status id
		Integer statusId=code.getStatusID(doctor.getUiStatus());
		

			
			String DoctorRegID=code.createNewTrackerId(3);
			
			doctor.setDoctorID(DoctorRegID);
			
			
			
			doctor.setStatus(statusId);
			
			//doctor.setCreatedBy(clinic_Details.getClinicID());
			
			java.util.Date date=new java.util.Date();
			doctor.setCreatedOn(new Date(date.getTime()));
			
			doctor=	doctor_Repository.save(doctor);
			
			code.UpdatedTrackerID(3, DoctorRegID);
			
		//	logger.info("Doctor Register Successful");

			doctor.setUiStatus(code.getStatus(doctor.getStatus()));
			return doctor;
	}

	@Override
	public List<Doctor> GetAllDoctorByClinicId(String clinicId) throws Exception {
		List<Doctor> list=new ArrayList<Doctor>();
		
		List<Doctor> listdoctor=doctor_Repository.getDoctorByClinicID(clinicId);
		for (Doctor doctor_Reg : listdoctor) {
			doctor_Reg.setUiStatus(code.getStatus(doctor_Reg.getStatus()));
			list.add(doctor_Reg);
		}
		
		return list;
	}
	
	

	@Override
	public List<Doctor> GetAllDoctor() throws Exception {

		List<Doctor> list=new ArrayList<Doctor>();
		
		List<Doctor> listdoctor=doctor_Repository.findAll();
		for (Doctor doctor_Reg : listdoctor) {

			doctor_Reg.setUiStatus(code.getStatus(doctor_Reg.getStatus()));
			list.add(doctor_Reg);

		}
		return list;
	}

	@Override
	public String remove_Dactor( String clinicID, String doctorID) throws Exception {
		String response=null;
		if(doctor_Repository.existsById(doctorID)) {
			doctor_Repository.deleteById(doctorID);
			response= "success delete";
		}
		else {
			response= "unsuccess delete";
		}
		
		return response;
	}

}
