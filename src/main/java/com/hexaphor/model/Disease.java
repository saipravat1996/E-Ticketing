package com.hexaphor.model;

import java.sql.Date;

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
@Table(name="Disease")
public class Disease {
	
	@Id
	private String diseaseId;
	private String diseaseName;
	private Date updatedBy;
	private Date createdBy;
	private Integer status;

}
