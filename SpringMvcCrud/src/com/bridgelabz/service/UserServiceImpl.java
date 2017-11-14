package com.bridgelabz.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bridgelabz.model.User;
import com.bridgelabz.model.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userdao;
	public void setUserDao(UserDao userdao)  {
		this.userdao=userdao;
	}
@org.springframework.transaction.annotation.Transactional
	public void addUser(User user) {
		this.userdao.addUser(user);
		
	}
	@org.springframework.transaction.annotation.Transactional

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userdao.updateUser(user);
	}
@org.springframework.transaction.annotation.Transactional
	public List<User> displayList() {
		// TODO Auto-generated method stub
		return this.userdao.displayList();
	}
@org.springframework.transaction.annotation.Transactional
	public void deleteuser(int id) {
		// TODO Auto-generated method stub
		this.userdao.deleteuser(id);
	}


}
