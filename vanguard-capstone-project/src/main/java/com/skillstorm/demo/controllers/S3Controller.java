package com.skillstorm.demo.controllers;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skillstorm.demo.services.S3Service;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class S3Controller {

    private S3Client s3;
    private final String bucketName = "simran-proj3-bucket";

    private final S3Service s3Service;

    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;

        // Set the AWS region using the Region enum
        Region region = Region.US_EAST_1;

        // Create AWS credentials
        AwsBasicCredentials credentials = AwsBasicCredentials.create(
                s3Service.accessKeyId,
                s3Service.secretAccessKey
        );

        // Create S3 client with the specified region and credentials
        this.s3 = S3Client.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            // Get the file name and size
            String fileName = file.getOriginalFilename();
            long fileSize = file.getSize();

            // Set the S3 bucket key
            String bucketKey = fileName;

            // Create a PutObjectRequest with the bucket name and key
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(bucketKey)
                    .build();

            // Stream the file contents directly to S3 using the S3Client's putObject method
            s3.putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, fileSize));

            return "File uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }
}
