package com.hexaphor.service;

import java.util.List;

import com.hexaphor.model.Patient;

public interface IPatientService {
	
	public Patient Patient_Registration(Patient patient_Reg_Pojo)throws Exception;
	
	public List<Patient> get_All_Patient_Registration()throws Exception;
	
	public Patient get_Patient_By_Id(String patientID)throws Exception;

}
