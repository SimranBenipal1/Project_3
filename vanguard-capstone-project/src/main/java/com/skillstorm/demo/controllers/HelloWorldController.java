package com.skillstorm.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Value("${my.env.mode}") 
	private String mode;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "You are Currently in: " + mode; 
	}
}
