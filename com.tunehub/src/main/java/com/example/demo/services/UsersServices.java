package com.example.demo.services;

import com.example.demo.entities.Users;
public interface UsersServices {
    //giving or intiliazing the user and emailExists 
	public String addUser(Users user);
	public boolean emailExists(String email);
	//checking for login if the user is present or not
	public boolean validateuser(String email,String password);
	public String getRole(String email);
	
	public Users getUser(String email);
	public void updateUser(Users user);
}
