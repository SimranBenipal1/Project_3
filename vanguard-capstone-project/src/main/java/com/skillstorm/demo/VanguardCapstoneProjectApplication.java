package com.skillstorm.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class VanguardCapstoneProjectApplication implements CommandLineRunner {

	@Value("${my.env.mode}") 
	private String mode;
	
    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    
    @Value("${aws.secretKey}")
    private String secretAccessKey;
	
	public static void main(String[] args) {
		SpringApplication.run(VanguardCapstoneProjectApplication.class, args);
		System.out.println("Spring server has started");
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Currently in: " + mode);
		//System.out.println(accessKeyId);
		//System.out.println(secretAccessKey);
	}
}
