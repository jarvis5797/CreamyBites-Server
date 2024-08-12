package com.creamybites.creamy_bites_server.service;

import com.creamybites.creamy_bites_server.entities.Users;

public interface UserService {
	
	public String sendOtpForUser(String email);
	
	public String addUser(Users user);

}
