package com.creamybites.creamy_bites_server.dao;

import com.creamybites.creamy_bites_server.entities.Users;

public class JwtAuthenticationResponse {
	
	private String token;
	
	private Users user;

	public JwtAuthenticationResponse(String token, Users user) {
		super();
		this.token = token;
		this.user = user;
	}

	public JwtAuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationResponse [token=" + token + ", user=" + user + "]";
	}
	
	

}
