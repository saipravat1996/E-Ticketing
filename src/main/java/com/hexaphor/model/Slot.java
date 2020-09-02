package com.hexaphor.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Slot {
	
	
	  @Id 
	  @GeneratedValue
	private Integer slotId;
	 
	private String slotName;
	private Timestamp StartDate;
	@Temporal(TemporalType.TIME)
	private Date stratTime;
	@Temporal(TemporalType.TIME)
	private Date endTime;
	

}
