package com.creamybites.creamy_bites_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creamybites.creamy_bites_server.entities.Users;
import com.creamybites.creamy_bites_server.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class UsersController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@CrossOrigin
	@PostMapping("/signUp")
	public ResponseEntity<?> addUser(@RequestBody Users user){
		return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.addUser(user));
	}
}
