package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepositories;

@Service
public class UsersServiceImplementation implements UsersServices {
	
	@Autowired
	UserRepositories repo;
	@Override
	//user if added successfully
	public String addUser(Users user) {
		repo.save(user);
		return "User Added Successfully";
	}
	@Override
	//checking if email already exists or not
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	@Override
	//validating the user for email and password by creating user for email and pass for password
	public boolean validateuser(String email, String password) {
		Users user=repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass)) {
			return true;
		}
		else {
		return false;
		}
	}
	@Override
	public String getRole(String email) {
		Users user=repo.findByEmail(email);
		return user.getRole();
	}
	
	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}
	
	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

}
