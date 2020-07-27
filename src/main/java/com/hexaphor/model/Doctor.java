package com.hexaphor.model;

import java.sql.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="doctor")
public class Doctor {
	
	public static Doctor doctor_Reg=null;
	
	//singleTone class
		public static Doctor getInstant(){
			if(doctor_Reg==null){
				Doctor doctor=new Doctor();
				doctor_Reg=doctor;
			}
			return doctor_Reg;
		}
	@Id
	private String doctorID;
	private String doctorName;
	private String clinicID;
	private Long mobileNumber;
	private Long whatsappNumber;
	private String emailId;
	private String degree;
	@ElementCollection(fetch = FetchType.EAGER)
	private String[] specialization;
	private Integer status;
	private Date createdOn;
	private String createdBy;
	private Date updatedOn;
	private String updatedBy;
	private String uiStatus;
	@Transient
	private String registrationType;//eg indert or update

	
}
