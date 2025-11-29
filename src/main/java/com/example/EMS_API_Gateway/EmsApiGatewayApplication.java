package com.example.EMS_API_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class EmsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApiGatewayApplication.class, args);
	}

	@Bean
	public CorsWebFilter corsWebFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		
		// 1. FIXED: Use Arrays.asList() for multiple origins
		corsConfig.setAllowedOrigins(Arrays.asList(
			"http://localhost:3000", 
			"https://main.d15ztt0s52f8f4.amplifyapp.com/"
		));
		
		// 2. Allow all HTTP methods (GET, POST, PUT, DELETE, OPTIONS)
		corsConfig.setMaxAge(3600L); // Cache preflight response for 1 hour
		corsConfig.addAllowedMethod("*");
		
		// 3. Allow all headers (Authorization, Content-Type, etc.)
		corsConfig.addAllowedHeader("*");
		
		// 4. Allow Credentials (cookies/tokens)
		corsConfig.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}
}