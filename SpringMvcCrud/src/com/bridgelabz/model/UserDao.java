package com.bridgelabz.model;

import java.util.List;

public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public  List<User> displayList();
	public void deleteuser(int id);
	
	

}
