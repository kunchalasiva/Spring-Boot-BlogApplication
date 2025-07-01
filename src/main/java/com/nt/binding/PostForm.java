package com.nt.binding;

import com.nt.entity.UserRegistration;

import lombok.Data;

@Data
public class PostForm {
	
	private String title;
	private String description;
	private String content;
	private Integer user;

}
