package com.skillstorm.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloWorldController {
	
	@Value("${my.env.mode}") 
	private String mode;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "You are Currently in: " + mode; 
	}
	
	@GetMapping("/userinfo")
	@ResponseBody // Send the data as JSON
	public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User user) {
		// Info about the user
		return user.getAttributes();
	}
	
}
