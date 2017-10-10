package com.prateek.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.prateek.Model.Register;



@Component
public class FormValidater implements Validator {

	
	public boolean supports(Class<?> arg0) {

		return Register.class.equals(arg0);
	}

	
	public void validate(Object arg0, Errors errors) {
		
		Register reg = (Register) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Please Enter Your name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.age", "Please Enter Your age");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Please Enter Your Email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adhaar_Id", "error.adhaar_Id", "Please Enter Your id");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Please Enter Your username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Please Enter Your password");
		Pattern patt = Pattern.compile(
				"^((([!#$%&'*+\\-/=?^_`{|}~\\w])|([!#$%&'*+\\-/=?^_`{|}~\\w][!#$%&'*+\\-/=?^_`{|}~\\.\\w]{0,}[!#$%&'*+\\-/=?^_`{|}~\\w]))[@]\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)$");
		Matcher matcher = patt.matcher(reg.getEmail());

		if (matcher.find()) {
			System.out.println("Valid");
			System.out.println(reg.getEmail());
		} else {
			System.out.println(reg.getEmail());
			System.out.println("Not Valid");
			errors.rejectValue("email", "error.email", "Invalid emailId");
		}

		patt = Pattern.compile("^(([a-zA-Z]+\\d+)|(\\d+[a-zA-Z]+))[a-zA-Z0-9]*$");
		matcher = patt.matcher(reg.getPassword());

		if (matcher.find()) {
			System.out.println("Valid");
			//System.out.println(reg.getEmail());
		} else {
			//System.out.println(reg.getEmail());
			System.out.println("Not Valid");
			errors.rejectValue("password", "error.password", "Should contain atleast one alphabet and one number");
		}

	}

	public void validate1(Object arg0, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Please Enter Your username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Please Enter Your password");

	}
}
