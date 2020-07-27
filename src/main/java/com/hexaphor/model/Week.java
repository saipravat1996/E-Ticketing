package com.hexaphor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="week")
public class Week {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer weekID;
	public String day;
	
	
}
