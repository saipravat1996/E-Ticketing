package com.hexaphor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrackerId {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer trackerId;
	private String tableName;
	private String prefix;
	private Integer fileSize;
	private String lastIdInsert;
	
}
