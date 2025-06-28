package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/")
	public String homepage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
