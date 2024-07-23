package com.creamybites.creamy_bites_server.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.creamybites.creamy_bites_server.dao.JwtAuthenticationResponse;
import com.creamybites.creamy_bites_server.dao.SignInRequest;
import com.creamybites.creamy_bites_server.entities.Users;
import com.creamybites.creamy_bites_server.repository.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtAuthenticationResponse signIn(SignInRequest request) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			
			Users user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or Password"));
			
			var jwt = jwtService.generateToken(user);
			
			JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse(jwt, user);
			return authenticationResponse;
			
		}catch (BadCredentialsException ex) {
			throw new BadCredentialsException("Invalid email or password");
		}catch(AuthenticationException ex) {
			throw new IllegalStateException("Authentication failed: "+ ex.getMessage());
		}
	}
}
