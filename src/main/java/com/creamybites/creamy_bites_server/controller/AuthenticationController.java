package com.creamybites.creamy_bites_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creamybites.creamy_bites_server.dao.JwtAuthenticationResponse;
import com.creamybites.creamy_bites_server.dao.SignInRequest;
import com.creamybites.creamy_bites_server.serviceImpl.AuthenticationService;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	
	
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
}
