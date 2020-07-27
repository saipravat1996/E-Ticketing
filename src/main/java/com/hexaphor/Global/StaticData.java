package com.hexaphor.Global;

import java.util.ArrayList;
import java.util.List;

import com.hexaphor.model.Clinic;
import com.hexaphor.model.LoginUser;
import com.hexaphor.model.Patient;
import com.hexaphor.model.Status;

public  class  StaticData {
	
	public static  List<Patient> getAllPatient=new ArrayList<Patient>();
	public static Patient patientByID=new Patient();
	public static List<LoginUser> GetAllLoginUser=new ArrayList<LoginUser>();
	public static LoginUser GetLoginUserByUserName=new LoginUser();
	public static List<Status> AllStatusDetails=new ArrayList<Status>();
	public static Clinic clinic_Details=new Clinic();
	public static List<Clinic> listClinics =new ArrayList<Clinic>();
	
}
