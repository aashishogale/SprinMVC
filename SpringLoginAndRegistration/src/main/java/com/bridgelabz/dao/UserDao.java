package com.bridgelabz.dao;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

/**
 * @author aashish
 *
 */
public interface UserDao {

	/**
	 * @param user-register
	 *            the user
	 *
	 */
	public boolean register(User user);

	/**
	 * @param login
	 * @return user-the validated user
	 * @purpose validate the user
	 */
	public User validateUser(Login login);

	public void changePassword(String email, String password);

	public boolean checkEmail(String email);
}
