package com.bridgelabz.service;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

/**
 * @author aashish
 *
 */

public interface UserService {

	/**
	 * @param user
	 * @purpose register the user
	 * 
	 */
	public void register(User user);

	/**
	 * @param login
	 * @return user-validated user
	 */
	public User validateUser(Login login);

}
