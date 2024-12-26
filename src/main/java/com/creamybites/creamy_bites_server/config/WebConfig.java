package com.creamybites.creamy_bites_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") 
        		.allowedOrigins("http://localhost:5173", 
        				"http://localhost:3000" , "http://192.168.1.8:3000",
        				"http://139.59.5.205:3000","http://10.47.0.5:3000",
        				"http://10.122.0.2:3000","http://172.18.0.2:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE" , "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
