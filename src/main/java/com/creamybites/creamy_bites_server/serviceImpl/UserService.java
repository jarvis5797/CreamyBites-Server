package com.creamybites.creamy_bites_server.serviceImpl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.creamybites.creamy_bites_server.entities.Users;
import com.creamybites.creamy_bites_server.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
				return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found")); 
			}
		};
	}
	
	public String save(Users user) {
		if(user.getUserId()==null) {
			user.setCreatedAt(new Date());
		}
		user.setUpdatedAt(new Date());
		userRepository.save(user);
		return "user saved successfully";
	}
	
}
