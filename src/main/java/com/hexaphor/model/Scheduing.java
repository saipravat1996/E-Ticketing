package com.hexaphor.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="scheduling")
public class Scheduing {
	private String schedulingId;
	//private String schedulingName;
	private String clinicId;
	private String clinicName;
	private String doctorId;
	private String doctorName;
	private Date bookingStartTime;
	private Date bookingEndTime;
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="slot_mapping")
	private List<Slot> slot_mapping;
	private Long totalTicket;
	
	

}
