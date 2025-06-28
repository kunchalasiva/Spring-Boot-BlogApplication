package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.binding.RegisterForm;
import com.nt.entity.Post;
import com.nt.entity.UserRegistration;
import com.nt.repository.UserRepository;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String userRegister(RegisterForm form) {
		
		UserRegistration user = new UserRegistration();
		BeanUtils.copyProperties(form, user);
		
		// use the repo
			userRepo.save(user);
		return "Registration Success";
	}
	
	@Override
	public String addBlog(Post post) {
		return null;
	}

}
