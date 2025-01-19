package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.services.UsersServices;
import com.example.demo.services.SongService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersServices service;
	
	@Autowired
	SongService songservice;
	@PostMapping("/register")
	// Instead of writing all Strings in user class instead calling it using model
	// Attribute
	public String addUsers(@ModelAttribute Users user) {
		boolean userStatus = service.emailExists(user.getEmail());
		// checking if the user already exists or not if not add user to database
		if (userStatus == false) {
			service.addUser(user);
			System.out.println("User Added");
		} else {
			System.out.println("User Already Exists");
		}
		return "login";
	}

	@PostMapping("/validate")
	// validating the user for login button and when matches admin page it goes to
	// Admin page
	// validating the user for login button and when matches customer page it goes
	// to customer page
	// now we added extra parameter called httpession to maintain seesion of the
	// user
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, Model model) {
		if (service.validateuser(email, password) == true) {
			String role = service.getRole(email);
			// calling session of the user by tracking the email
			session.setAttribute("email", email);

			if (role.equals("admin")) {
				// matches goes to adminHome page
				return "adminHome";
			} else {
				// matches goes to customerHome page
				//we are going to get customer mail from users database
				Users user=service.getUser(email);
				//we know from below whrther is user is a premium user ot not
				boolean userStatus=user.isPremium();
				model.addAttribute("isPremium", userStatus);
				//after verfiying it is the prrmium user it displays the songs
				List<Song> songList = songservice.fetchAllSongs();

				// printing the list of songs on to the web page called display songs
				model.addAttribute("songs", songList);
				return "customerHome";
			}
		} else {
			// false login will reload
			return "login";
		}
	}

/*	@GetMapping("/pay")

	public String pay(@RequestParam String email) {
		boolean paymentStatus = false;// payment api

		if (paymentStatus == true) {
			Users user = service.getUser(email);
			user.setPremium(true);
			service.updateUser(user);
		}

		return "login";
	}*/

	// Here when we click on logout we go to login page
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		// login page is displayed when clicked on logout
		return "login";
	}

}
