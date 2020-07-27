package com.hexaphor.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Clinic")
public class Clinic {
	@Id
	private String clinicID;
	@Column(unique = true)
	private String clinicName;
	private String Address;
	private String Address1;
	private Integer pincode;
	@Column(unique = true)
	private Long phoneNumber;
	private Long whatsappNumbre;
	@Column(unique = true)
	private String gmailID;
	@Column(unique = true)
	private String loginID;
	private int status;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;
	private String role;
	@Transient
	private String uiStatus;
	@Transient
	public String type;
	@Transient
	private String loginName;
	@Transient
	private String password;
	
	

}
