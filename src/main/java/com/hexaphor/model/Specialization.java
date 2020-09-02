package com.hexaphor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="specialization")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {

	@Id
	private String specializationId;
	private String specializationName;
	private String clinicId;
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	private String updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
}
