package com.bridgelabz.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

/**
 * @author aashish
 *
 */
@Controller
public class RegisterController {
	@Autowired
	public UserService userService;
	@Autowired
	private MailSender mailSender;
	private static final Logger logger = Logger.getLogger(RegisterController.class);

	/**
	 * @param request
	 * @param response
	 * @return mav -register page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	/**
	 * @param request
	 * @param response
	 * @param user
	 * @return got to login page
	 */
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {


		
		if(userService.register(user, request)) {
			
			
			logger.info("register process is executed!");
			HttpSession session = request.getSession(true);

			session.setAttribute("message", "session created");
			
			return new ModelAndView("redirect:login");
			
		}

	      
		
	 return new ModelAndView("redirect:/"); 	
		
	
	}
	
	


}

