package com.hexaphor.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Slot")
public class Slot {
	
	@Id
	private String slotId;
	private String slotName;
	private Timestamp StartDate; 
	private String stratTime;
	private String endTime;
	

}
