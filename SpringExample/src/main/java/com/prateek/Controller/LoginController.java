package com.prateek.Controller;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prateek.Model.Login;
import com.prateek.Model.Register;
import com.prateek.Services.FormValidater;
import com.prateek.Services.UserService;


@Controller
public class LoginController {
	
	@Autowired
	UserService service;

	@Autowired
	FormValidater validator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView dologinbean() {
		
		ModelAndView mav = new ModelAndView("login");
		Login loginuser = new Login();
		mav.addObject("loginuser", loginuser);
		return mav;

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView Logout(HttpServletRequest request) {

		
		HttpSession session = request.getSession();
		session.invalidate();

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginuser", new Login());
		mav.addObject("messages", "Successfully Logged Out");
		return mav;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView goToLogin() {

		ModelAndView mav = new ModelAndView("login");
		Login loginuser = new Login();
		mav.addObject("loginuser", loginuser);
		return mav;

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginuser(@ModelAttribute("loginuser") Register loginuser, BindingResult result,
			HttpServletRequest request, HttpSession session) {
		
		validator.validate1(loginuser, result);
		if (result.hasErrors()) {

			ModelAndView mav = new ModelAndView("login");

			return mav;
		} else {
			
			session = request.getSession(true);
			session.setAttribute("userObject", loginuser);
			
			Login login = new Login();
			
			login.setUsername(loginuser.getUsername());
			login.setPassword(loginuser.getPassword());
			
			Register reg = service.getUser(login);
			
			ModelAndView mav = null;
			if (reg != null) {
				
				mav = new ModelAndView("welcome");
				mav.addObject("loginuser", reg);
			} else {
				mav = new ModelAndView("login", "message", "Invalid Login");
			}
			return mav;
		}
	}

}
