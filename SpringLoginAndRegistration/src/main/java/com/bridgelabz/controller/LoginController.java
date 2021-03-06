package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

/**
 * @author aashish
 *
 */
@Controller
public class LoginController {
	@Autowired
	UserService userService;
	private static final Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * @param request
	 * @param response
	 * @return mav-login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	/**
	 * @param request
	 * @param response
	 * @param login
	 * @return mav- validate the user
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if (null != user) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			return new ModelAndView("redirect:/welcome");
		} else {

			logger.warn("login unsuccesful user not found");
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

	@RequestMapping(value = "/register")
	public ModelAndView showregister(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/otp")
	public ModelAndView showOtp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("otppage12");

		System.out.println("method called");
		return mav;
	}

	@RequestMapping(value = "/generateOtp", method = RequestMethod.POST)
	public ModelAndView generateOtp(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("email", request.getParameter("email"));
		if (userService.checkEmail(request.getParameter("email"))) {
			userService.generateOtp(request.getParameter("email"));
			return new ModelAndView("otpval");

		}
		ModelAndView mav = new ModelAndView("otppage12");
		mav.addObject("message", "please enter correct email");
		return mav;

	}

	@RequestMapping(value = "/validateOtp", method = RequestMethod.POST)
	public ModelAndView validateOtp(HttpServletRequest request, HttpServletResponse response) {
		int otp = Integer.parseInt(request.getParameter("otp"));
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if (userService.validateOtp(email, otp)) {
			return new ModelAndView("changepassword");

		}
		ModelAndView mav = new ModelAndView("otpval");
		mav.addObject("message", "please enter correct otp");
		return mav;
	}

	@RequestMapping(value = "/changepasswordprocess", method = RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		userService.changePassword(email, password);
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		mav.addObject("message", "password successfully changed");
		return mav;

	}
}
