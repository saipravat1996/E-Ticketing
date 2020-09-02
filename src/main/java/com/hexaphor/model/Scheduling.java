package com.hexaphor.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name="scheduling")
public class Scheduling {
	@Id
	private String schedulingId;
	//private String schedulingName;
	private String clinicId;
	private String clinicName;
	private String doctorId;
	private String doctorName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingStartTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingEndTime;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="slottab",joinColumns = @JoinColumn(name="schedulingId"))
	@Column(name="slotmapping")
	private List<Slot> slotMapping;
	private Long totalTicket;
	
	

}
