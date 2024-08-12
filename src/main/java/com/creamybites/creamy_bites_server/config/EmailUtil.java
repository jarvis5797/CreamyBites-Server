package com.creamybites.creamy_bites_server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendVerificationCode(String email , String otp ) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setSubject("Verification Mail for CreamyBites!");
			helper.setText("Use this verification code to verify your email for CremayBites.com: "+otp);
			helper.setTo(email);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("Unable to send email to "+email);
		}
	}

}
