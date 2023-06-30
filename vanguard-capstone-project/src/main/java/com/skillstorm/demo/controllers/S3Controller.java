package com.skillstorm.demo.controllers;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skillstorm.demo.services.S3Service;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.instrumentation.annotations.WithSpan;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * The Class S3Controller.
 */
@RestController
public class S3Controller {

    /** The s3 */
    private S3Client s3;
    
    /** The bucket name. */
    private final String bucketName = "simran-proj3-bucket";

    /** The s3 service. */
    private final S3Service s3Service;

    /**
     * Instantiates a new s3 controller.
     *
     * @param s3Service the s3 service
     */
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
                .serviceConfiguration(S3Configuration.builder()
                        .pathStyleAccessEnabled(true)
                        .build())
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    /**
     * Handle file upload.
     *
     * @param file the file
     * @return The URL of the Uploaded Image
     */
    @PostMapping("/upload")
    @WithSpan
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    	Tracer tracer = GlobalOpenTelemetry.getTracer("GoalManagementService");
    	Span fileSpan = tracer.spanBuilder("handleFileUpload.configureFile").startSpan();
        try (InputStream inputStream = file.getInputStream()) {
        	
        	
            // Get the file name and size
            String fileName = file.getOriginalFilename();
            long fileSize = file.getSize();

            // Generate a random unique string
            String uniqueString = UUID.randomUUID().toString();

            // Set the S3 bucket key
            String bucketKey = uniqueString + "-" + fileName;

            fileSpan.end();
            Span bucketPutSpan = tracer.spanBuilder("handleFileUpload.bucketPut").startSpan();
            // Create a PutObjectRequest with the bucket name and key
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(bucketKey)
                    .build();

            // Stream the file contents directly to S3 using the S3Client's putObject method
            PutObjectResponse response = s3.putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, fileSize));

            if (response.sdkHttpResponse().isSuccessful()) {
                // Construct the URL of the uploaded file
                String fileUrl = String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, Region.US_EAST_1.id(), bucketKey);
            	bucketPutSpan.end();
                return fileUrl;
            } else {
            	bucketPutSpan.end();
                return "Failed to upload file";
            }

        } catch (IOException e) {
        	fileSpan.end();
            e.printStackTrace();
            return "Failed to upload file";
        }
    }

}
