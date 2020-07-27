package com.hexaphor.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="DiseaseDoctorMapping")
public class DiseaseDoctorMapping {
	@Id
	private String diseaseDoctorMappingId;
	private String doctorId;
	private String diseaseId;
	private Date updatedBy;
	private Date createdBy;
	private Integer status;
	
	@Transient
	private String diseaseName;
	@Transient
	private String doctorName;
}
