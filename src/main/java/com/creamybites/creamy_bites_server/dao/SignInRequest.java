package com.creamybites.creamy_bites_server.dao;

public class SignInRequest {
	
	private String email;
	
	private String password;

	public SignInRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public SignInRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignInRequest [email=" + email + ", password=" + password + "]";
	}
	
	

}
