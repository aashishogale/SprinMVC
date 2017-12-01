package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public void  register(User user) {
		
		userDao.register(user);
	}
    public User login(String userName, String password){
		return userDao.login(userName, password);
	}

	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		return userDao.validateUser(login);
	}

}
