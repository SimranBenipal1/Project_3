package com.skillstorm.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

    @Value("${aws.accessKeyId}")
    public String accessKeyId;
    
    @Value("${aws.secretKey}")
    public String secretAccessKey;
}
