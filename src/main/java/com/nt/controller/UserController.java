package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.binding.RegisterForm;
import com.nt.service.UserServiceImple;


@Controller
public class UserController {

	@Autowired
	private UserServiceImple service;
	
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
		att.addFlashAttribute("message", message);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginUser() {
	  return "login";	
	}
}
