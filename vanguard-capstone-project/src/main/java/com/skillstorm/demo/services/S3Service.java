package com.skillstorm.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * The Class S3Service. Exists to pass in Env Variables to the S3 Controller
 * at value does not work for controllers 
 */
@Service
public class S3Service {

    /** The access key id. */
    @Value("${aws.accessKeyId}")
    public String accessKeyId;
    
    /** The secret access key. */
    @Value("${aws.secretKey}")
    public String secretAccessKey;
}
