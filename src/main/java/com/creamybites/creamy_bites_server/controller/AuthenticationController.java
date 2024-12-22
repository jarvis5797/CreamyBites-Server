package com.creamybites.creamy_bites_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creamybites.creamy_bites_server.dao.JwtAuthenticationResponse;
import com.creamybites.creamy_bites_server.dao.SignInRequest;
import com.creamybites.creamy_bites_server.serviceImpl.AuthenticationService;
import com.creamybites.creamy_bites_server.serviceImpl.UserServiceImpl;

import ch.qos.logback.core.status.Status;
import jakarta.mail.SendFailedException;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@CrossOrigin
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest){
		try {
			JwtAuthenticationResponse authenticationResponse = authenticationService.signIn(signInRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);
		}catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Email or Password");
		}
	}
	
	@CrossOrigin
	@GetMapping("/sendOtp/{email}")
	public ResponseEntity<?> sendOtp(@PathVariable("email") String email){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.sendOtpForUser(email));
		} catch (MailSendException e) {
			return ResponseEntity.status(HttpStatus.OK).body("Invalid Email!!");
		}
	}
	
	@CrossOrigin
	@GetMapping("/verifyEmail/{otp}/{hash}")
	public ResponseEntity<?> verifyEmail(@PathVariable("otp") String otp ,@PathVariable("hash") String hash ){
		if(userServiceImpl.generateHash(otp).equals(hash)) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(false);
		}
	}
}
