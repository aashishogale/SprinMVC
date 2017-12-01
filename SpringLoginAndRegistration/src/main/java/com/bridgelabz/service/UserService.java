package com.bridgelabz.service;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;


public interface UserService {
	public void register(User user);

	public User login(String userName, String password) ;
	


	User validateUser(Login login);

}
