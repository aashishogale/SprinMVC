package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.User;

public interface UserService {
	public void addUser(User user);
	public void updateUser(User user);
	public  List<User> displayList();
	public void deleteuser(int id);
	

}
