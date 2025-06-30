package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.UserRegistration;

public interface UserRepository extends JpaRepository<UserRegistration, Integer>{

	
	public UserRegistration findByUserEmail(String email);
	
	public UserRegistration findByUserEmailAndUserPassword(String email,String password);

}
