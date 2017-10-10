package com.prateek.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prateek.Model.Login;
import com.prateek.Services.GenOtpService;
import com.prateek.Services.UserService;



@Controller
public class ResetPasswordController {

	@Autowired
	UserService service;

	@Autowired
	GenOtpService mailService;

	@RequestMapping("forgotPass")
	public ModelAndView forgotPass() {

		ModelAndView mav = new ModelAndView("resetPass");

		return mav;
	}

	@RequestMapping("reset")
	public String resetPass(HttpServletRequest request, ModelMap model) {

		String name, uname, email;

		uname = request.getParameter("uname");

		name = service.checkUser(uname);
		email = service.getEmail(uname);

		if (name == null) {

			model.addAttribute("message", "Invalid Username!");
			
			return "resetPass";
		} else {

			model = mailService.sendMail(email);

			request.setAttribute("OTP", model.get("OTP"));

			request.setAttribute("emaill", email);
			return "reset";
		}

	}

	@RequestMapping("updatePass")
	public String updatePass(HttpServletRequest request, ModelMap mode) {

		String genCode = request.getParameter("genCode");
		String usrCode = request.getParameter("usrCode");

		if (usrCode.equals(genCode)) {
			System.out.println("OTPs Match");
			return "updatePass";
		} else {
			System.out.println("OTPs not Matching");
			mode.addAttribute("message2", "OTPs doesn't match! try again");
			return "redirect:reset";

		}

	}

	@RequestMapping("finalReset")
	public ModelAndView DbUpdate(HttpServletRequest request) {

		ModelAndView mode = new ModelAndView("login");
		String email, pass;
		email = request.getParameter("email");
		pass = request.getParameter("pass");
		service.updatePass(email, pass);
		Login loginuser = new Login();
		mode.addObject("loginuser", loginuser);
		mode.addObject("messages","Password Successfully Updated");

		return mode;
	}
}