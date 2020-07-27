package com.hexaphor.model;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DoctorAvailbility {

	@Id
	private String doctoravailblityID;
	private String clinicID;
	private String doctorID;
	private int dayID;
	private LocalTime startTime;
	private LocalTime endTime;
	private int status;
	private String createdBy;
	private String updatedBy;
	private Date createdOn;
	private Date updatedOn;
	
}
