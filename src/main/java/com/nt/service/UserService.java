package com.nt.service;

import com.nt.binding.LoginForm;
import com.nt.binding.PostForm;
import com.nt.binding.RegisterForm;
import com.nt.entity.Post;

public interface UserService {

	public abstract String userRegister(RegisterForm form);
	
	public abstract String loginUser(LoginForm form);
	
	public abstract String addBlogPost(PostForm form);
}
