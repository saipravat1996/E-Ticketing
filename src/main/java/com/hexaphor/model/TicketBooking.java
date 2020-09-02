package com.hexaphor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ticketbooking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketBooking {

	@Id
	private String ticketId;
	private String clinicId;
	private String clinicName;
	private String doctorId;
	private String doctorName;
	private String schedulingId;
	private String slotId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingTime;
	@Column(unique = true)
	private String otp;
	
}
