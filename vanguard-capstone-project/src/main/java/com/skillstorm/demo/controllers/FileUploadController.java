package com.skillstorm.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skillstorm.demo.services.S3FileUploadService;

@RestController
public class FileUploadController {

    @Autowired
    private S3FileUploadService s3FileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String url = s3FileUploadService.uploadFile(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(String.format("File uploaded successfully and can be found at: %s", url));
    }
}
