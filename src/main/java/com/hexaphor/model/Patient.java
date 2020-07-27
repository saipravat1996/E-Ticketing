package com.hexaphor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patient")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
	@Id
	private String patientId;
	private String patientName;
	@Column(unique = true)
	private Long mobileNumber;
	@Column(unique = true)
	private  String emailId;
	private String address;
	private String gender;
	@Column(unique = true)
	private String loginID;
	private  String createdBy;
	private String updatedBy;
	private String role;
	private Integer status;
	@Transient
	private String uiStatus;
	@Transient
	private String loginName;
	
	

	


	
}
