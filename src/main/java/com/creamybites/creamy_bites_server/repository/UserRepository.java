package com.creamybites.creamy_bites_server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.creamybites.creamy_bites_server.entities.Users;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);
	
}
