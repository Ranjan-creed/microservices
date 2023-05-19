package com.example.documentservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface DocumentService {

    Map<String,String> uploadSingleFile(MultipartFile file);
}
