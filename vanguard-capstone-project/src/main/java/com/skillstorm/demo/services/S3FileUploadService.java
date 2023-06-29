package com.skillstorm.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.io.UncheckedIOException;

@Service
public class S3FileUploadService {

    @Autowired
    private S3Client s3Client;

    private String bucketName = "simran-proj3-bucket";
    
    @Value("${aws.region}")
    private String region;

    public String uploadFile(MultipartFile file) {
        try {
            PutObjectResponse response = s3Client.putObject(PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(file.getOriginalFilename())
                            .build(),
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize())
            );

            if (response != null) {
                return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, file.getOriginalFilename());
            } else {
                throw new IllegalStateException("The file upload was unsuccessful.");
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}