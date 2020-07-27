package com.hexaphor.service;

import java.util.List;

import com.hexaphor.model.Doctor;

public interface IDoctorService {


	public Doctor doctor_RegistrationOrUpdate(Doctor doctor_Reg_Pojo)throws Exception;
	
	public List<Doctor> GetAllDoctorByClinicId(String ClinicId)throws Exception;
	
	public List<Doctor> GetAllDoctor()throws Exception;
	
	public String remove_Dactor(String clinicID,String doctorID)throws Exception;
	
	//public Doctor_Reg_Pojo doctor_Update(Doctor_Reg_Pojo doctor_Reg_Pojo)throws Exception;
	
}
