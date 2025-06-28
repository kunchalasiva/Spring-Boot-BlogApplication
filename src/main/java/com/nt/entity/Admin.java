package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "admin_tab")
@Entity
public class Admin {

	@Id
	private Integer adminId;
	
	private String adminName;
	
	private String adminPassword;
}
