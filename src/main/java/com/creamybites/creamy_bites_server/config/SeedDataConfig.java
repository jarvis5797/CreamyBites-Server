package com.creamybites.creamy_bites_server.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.creamybites.creamy_bites_server.constants.Role;
import com.creamybites.creamy_bites_server.entities.Users;
import com.creamybites.creamy_bites_server.repository.UserRepository;
import com.creamybites.creamy_bites_server.serviceImpl.UserService;

@Component
public class SeedDataConfig implements CommandLineRunner{

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final UserService userService;

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count() ==0) {
			Users admin = new Users();
			admin.setUserName("Admin");
			admin.setEmail("admincreamybites.com");
			admin.setPassword(passwordEncoder.encode("nkbrrbricky"));
			admin.setRole(Role.Admin);
			userService.save(admin);
		}
	}

	public SeedDataConfig(UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userService = userService;
	}
	
	
	
	
}
