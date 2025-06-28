package com.nt.service;

import com.nt.binding.RegisterForm;
import com.nt.entity.Post;

public interface UserService {

	public abstract String userRegister(RegisterForm form);
	
	public abstract String addBlog(Post post);
	
	
}
