package com.hexaphor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="roleMapping")
public class RoleMapping {

	@Id
	private String roleMappingId;
	private String role;
	private String dscription;
	
}
