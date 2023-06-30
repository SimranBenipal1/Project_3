package com.skillstorm.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

/**
 * The Class VanguardCapstoneProjectApplication.
 */
@SpringBootApplication
public class VanguardCapstoneProjectApplication implements CommandLineRunner {

	/** The mode. */
	@Value("${my.env.mode}") 
	private String mode;
	
    /** The access key id. */
    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    
    /** The secret access key. */
    @Value("${aws.secretKey}")
    private String secretAccessKey;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(VanguardCapstoneProjectApplication.class, args);
		System.out.println("Spring server has started");
	}
	
	/**
	 * Run.
	 *
	 * @param args the args
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Currently in: " + mode);
		//System.out.println(accessKeyId);
		//System.out.println(secretAccessKey);
	}
}
