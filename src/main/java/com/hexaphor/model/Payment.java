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
@Table(name="payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	private String paymentId;
	@Column(unique = true)
	private String transacationId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	private Double fees;
	private String paymentType;
	private String status;
	
	
}
