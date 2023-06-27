package com.skillstorm.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:5173")
public class HelloWorldController {
	
	@Value("${my.env.mode}") 
	private String mode;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "You are Currently in: " + mode; 
	}
	
	// Redirects the user to the frontend application (S3 bucket, localhost:5173)
	// Users should ONLY access the app using this
	// This is done to get the JSESSIONID cookie established (login with Google)
	@GetMapping("/signin")
	public RedirectView redirectView() {
		RedirectView redirectView = new RedirectView("http://localhost:5173");
		return redirectView;
	}
	
	@GetMapping("/userinfo")
	@ResponseBody // Send the data as JSON
	public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User user) {
		// Info about the user
		return user.getAttributes();
	}
	
}
