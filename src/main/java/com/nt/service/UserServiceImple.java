package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.binding.LoginForm;
import com.nt.binding.PostForm;
import com.nt.binding.RegisterForm;
import com.nt.entity.Post;
import com.nt.entity.UserRegistration;
import com.nt.repository.PostRepository;
import com.nt.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public String userRegister(RegisterForm form) {
		
		UserRegistration user = new UserRegistration();
		UserRegistration register=userRepo.findByUserEmail(form.getUserEmail());
		if(register!=null) {
			return "Email already taken";
		}
		
		BeanUtils.copyProperties(form, user);
		
		// use the repo
			userRepo.save(user);
		return "Registration Success";
	}
	
	@Override
	public String loginUser(LoginForm form) {
		// use the repository
		UserRegistration user=userRepo.findByUserEmailAndUserPassword(form.getUserEmail(), form.getUserPassword());
		
		if(user == null) {
		 return "Invalid credentials";
		}else {
			// get the id the of the user and set into the session
			session.setAttribute("UserId", user.getUserId());
			return "success";
		}
	}
	
	@Override
	public String addBlogPost(PostForm form) {
		Post post = new Post();
		BeanUtils.copyProperties(form, post);
		
		// get the userId
		post.setUser(form.getUser());
		
		// use the repository
		postRepo.save(post);
		
		return "Post Added";
	}

}
