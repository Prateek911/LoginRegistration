package com.prateek.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prateek.Model.Register;
import com.prateek.Services.FormValidater;
import com.prateek.Services.UserService;



@Controller
public class RegistrationController {

	@Autowired
	UserService service;

	@Autowired
	FormValidater validator;

	@RequestMapping(value = "Register", method = RequestMethod.GET)
	public ModelAndView doregistrationbean() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new Register());

		return mav;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String adduser(@ModelAttribute("user") Register user, BindingResult result) {
		validator.validate(user, result);
		if (result.hasErrors()) {

			return "register";
		} else {

			System.out.println(user);
			service.insertuser(user);
			return "redirect:/";

		}
	}

}
