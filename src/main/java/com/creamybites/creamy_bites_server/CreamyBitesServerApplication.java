package com.creamybites.creamy_bites_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CreamyBitesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreamyBitesServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:5173","https://creamy-bites.vercel.app").allowedMethods("*").maxAge(3600L)
						.allowedHeaders("*").exposedHeaders("Authorization").allowCredentials(true);
			}
		};
	}
}
