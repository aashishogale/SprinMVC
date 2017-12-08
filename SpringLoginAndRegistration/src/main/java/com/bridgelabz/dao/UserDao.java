package com.bridgelabz.dao;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

/**
 * @author aashish
 *
 */
public interface UserDao {

	/**
	 * @param user-register the user
	 *
	 */
	public void register(User user);

	/**
	 * @param login
	 * @return user-the validated user
	 * @purpose validate the user
	 */
	public User validateUser(Login login);

}
