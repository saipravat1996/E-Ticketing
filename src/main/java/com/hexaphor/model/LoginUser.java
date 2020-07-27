package com.hexaphor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="LoginUser")
public class LoginUser {
	@Id
	private String loginID;
	@Column(unique = true)
	private String loginName;
	private String password;
	private String role;
	
	

}
