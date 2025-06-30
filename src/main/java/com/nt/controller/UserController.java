package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.binding.LoginForm;
import com.nt.binding.PostForm;
import com.nt.binding.RegisterForm;
import com.nt.service.UserServiceImple;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {

	@Autowired
	private UserServiceImple service;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String homepage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("register", new RegisterForm());
		return "register";
	}
	
	@PostMapping("/save")
	public String registerUser(RegisterForm form,RedirectAttributes att) {
		// use the service
		String message=service.userRegister(form);
		if(message.contains("Registration Success")) {
			att.addFlashAttribute("message", message);
		}else {
			att.addFlashAttribute("errmessage", message);
		}
		return "redirect:/register";
	}
	
	@GetMapping("/login")
	public String loginUser(Model model) {
		model.addAttribute("Login",new LoginForm());
	  return "login";	
	}
	
	@PostMapping("/login")
	public String handleUserLogin(LoginForm form,Model model) {
		// use the service
		String result=service.loginUser(form);
		model.addAttribute("Login",new LoginForm());
		
		if(result.contains("success")) {
		  return "dashboard";	 
		}else {
			model.addAttribute("result", result);
			return "login";
		}
	}

	@GetMapping("/logout") 
	public String handleUserLogOut() {
	    Integer userId = (Integer) session.getAttribute("UserId"); 
	    System.out.println("Logging out user with ID: " + userId);
	    session.invalidate();
	    return "home";
	}

	
	@GetMapping("/dashboard")
	public String handleDashboard() {
		return "dashboard";
	}
	
	@GetMapping("/addpost")
	public String handlePost(Model model) {
		model.addAttribute("post",new PostForm());
		return "addpost";
	}
	
	@PostMapping("/addpost")
	public String handleAddPost(@ModelAttribute("post") PostForm form,Model model) {
		// use the service
		String message=service.addBlogPost(form);
		model.addAttribute("message",message);
		model.addAttribute("post",new PostForm());
		return "addpost";
	}


}
