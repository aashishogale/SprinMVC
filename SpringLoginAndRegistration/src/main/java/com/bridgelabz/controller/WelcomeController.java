package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome")
	public ModelAndView welcomepage(HttpServletRequest request) {
		ModelAndView mav = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null)
			return new ModelAndView("redirect:/login");

		mav = new ModelAndView("welcome");
		mav.addObject("user", user);
		return mav;
	}

}
