package com.bridgelabz.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.controller.MailSetter;
import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.Otp;
import com.bridgelabz.model.User;

/**
 * @author aashish implementing the userservice methods
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	private MailSender mailSender;

	@Transactional(rollbackFor=Exception.class)
	public boolean register(User user, HttpServletRequest request) {

		boolean saved = userDao.register(user);
		
		MailSetter mailSetter=new MailSetter();
		mailSetter.setMailSender(mailSender);
		mailSetter.sendMail(request.getParameter("email"));
		
		
		return saved;
	}

	@Transactional
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
	public void generateOtp(Otp otp){
		int randomnum = (int) (1000 + Math.random() * (9999 - 1000));
		
		userDao.generateOtp(otp,randomnum);
		
	}


}
