package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	//when clicked on login link it goes to login page
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	//when clicked on register link it goes to register page
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	//when clicked on navigation home it goes to home page
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/adminHome")
	public String adminHome() {
		return "adminHome";
	}
	
	@GetMapping("/customerHome")
	public String customerHome() {
		return "customerHome";
	}
	
	@GetMapping("/newSong")
	public String newSong() {
		return "newSong";
	}
	
	@GetMapping("/deletePlaylists")
	public String deletePlaylists() {
		return "deletePlaylists";
	}
}
