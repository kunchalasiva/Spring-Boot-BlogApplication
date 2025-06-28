package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.UserRegistration;

public interface UserRepository extends JpaRepository<UserRegistration, Integer>{

}
