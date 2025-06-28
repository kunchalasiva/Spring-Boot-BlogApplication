package com.nt.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_register_tab")
@Data
public class UserRegistration {

	@Id
	@GeneratedValue
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String userEmail;
	
	private String userPassword;
	
}
