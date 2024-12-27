package com.creamybites.creamy_bites_server.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.creamybites.creamy_bites_server.filters.JwtAuthenticationFilter;
import com.creamybites.creamy_bites_server.serviceImpl.UserService;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService.userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
		.cors(cors -> cors.configurationSource(corsConfigurationSource()))
		.csrf(csrf -> csrf.disable()).sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(HttpMethod.POST, "/api/v1/signUp" , "/api/v1/signin").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/v1/test/**" , "/" , "/api/v1/sendOtp/**" , "/api/v1/verifyEmail/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/v1/getallitems" , "/api/v1/getItemById/**").authenticated()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/swagger-ui.html", "/**").permitAll()
				.anyRequest().authenticated()
				)
		.authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(List.of("http://localhost:5173", 
				"http://localhost:3000" , "http://192.168.1.8:3000",
				"http://139.59.5.205:3000","http://10.47.0.5:3000",
				"http://10.122.0.2:3000","http://172.18.0.2:3000"));
	    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	    configuration.setAllowedHeaders(List.of("*"));
	    configuration.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}

	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserService userService,
			PasswordEncoder passwordEncoder) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	
}
