package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.Otp;
import com.bridgelabz.service.UserService;

public class OtpController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/otp", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("otp");
		mav.addObject("otp", new Otp());
		return mav;
	}

	@RequestMapping(value = "/generateOtp", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("otp") Otp otp) {
        HttpSession session=request.getSession();
        session.setAttribute("email", request.getParameter("email"));
		userService.generateOtp(otp);
		return new ModelAndView("otpval");

	}

}
