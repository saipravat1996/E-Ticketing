package com.hexaphor.service;



import java.util.List;

import com.hexaphor.model.Clinic;

public interface IClinicService {

	public Clinic Registration(Clinic clinic_Pojo)throws Exception;
	
	public List<Clinic> listClinic()throws Exception;
	
	public String RemoveClinic(String ClinicID)throws Exception;
	
	public Clinic getClinicDetails(String clinicID)throws Exception;
	
	public Clinic Update(Clinic clinic_Pojo)throws Exception;
	
	//check gmailID  registered or not
	public Integer countClinicGmail(String gmailID)throws Exception;
	//check phone Number  registered or not
	public Integer countClinicPhoneNumber(Long phoneNumber)throws Exception;
	//check client Name  registered or not
	public Integer countClinicName(String clinicName)throws Exception;
	//check Login Name  registered or not
	public Integer countLoginName(String loginName)throws Exception;
	
}
