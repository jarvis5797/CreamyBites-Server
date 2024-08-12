package com.creamybites.creamy_bites_server.serviceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.creamybites.creamy_bites_server.config.EmailUtil;
import com.creamybites.creamy_bites_server.constants.Role;
import com.creamybites.creamy_bites_server.entities.Users;
import com.creamybites.creamy_bites_server.repository.UserRepository;
import com.creamybites.creamy_bites_server.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String sendOtpForUser(String email) {
		if(userRepository.findByEmail(email).isEmpty()) {
			Random random = new Random();
			String otp = String.valueOf(100000+random.nextInt(900000));

			emailUtil.sendVerificationCode(email, otp);
			return generateHash(otp);

		}else {
			return "Email already registered!!";
		}
	}
	
	public String generateHash(String otp) {
		StringBuilder hash = new StringBuilder();
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(otp.getBytes());
			 for (byte b : hashBytes) {
		            hash.append(String.format("%02x", b));
		        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        return hash.toString();
	}

	@Override
	public String addUser(Users user) {
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setRole(Role.User);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "user created!!";
	}

}
