
package com.prateek.Services;

import java.util.Date; 
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class GenOtpService {

	public String getOTP() {
		Random rand= new Random();
		
		String otp = ""+rand.nextInt(9875365);
		
		return otp;
	}
	
	public ModelMap sendMail(String email) {
		
		String OTP;
		ModelMap mode = null;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // for gmail use smtp.gmail.com
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		try {
		Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("prateek.work911@gmail.com", "Oscar3Bravo");
			}
		});

		mailSession.setDebug(true); // Enable the debug mode

		Message msg = new MimeMessage(mailSession);

		// --[ Set the FROM, TO, DATE and SUBJECT fields
		msg.setFrom(new InternetAddress("prateek.work911@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSentDate(new Date());
		msg.setSubject("Password Reset");
		// --[ Create the body of the mail
		OTP = getOTP();
		msg.setText("Your OTP: " + OTP);
		mode = new ModelMap();
		mode.addAttribute("OTP", OTP);
		
		 
		// --[ Ask the Transport class to send our mail message
		Transport.send(msg);
		

	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		System.out.println("Oops something has gone pearshaped!");
		System.out.println(e);
		
	}
		
		return mode;
	}
}