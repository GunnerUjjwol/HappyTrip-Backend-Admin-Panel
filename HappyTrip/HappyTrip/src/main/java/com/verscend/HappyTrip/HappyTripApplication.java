package com.verscend.HappyTrip;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class HappyTripApplication {
	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(HappyTripApplication.class, args);
	}
}
