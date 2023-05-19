package com.example.documentservice.controller;

import com.example.documentservice.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/checkDocumentService")
    public String checkDocumentService(){return "Document Service is running !!!!";}

    @PostMapping("/uploadAFile")
    public Map<String,String> uploadSingleFile(@RequestParam("file") MultipartFile file){
        log.info("Inside uploadSingleFile");
        return documentService.uploadSingleFile(file);
    }

    @PostMapping("/checkException")
    public Map<String,String> checkException(@RequestBody Map<String,String> data){
        Map<String,String> response = new HashMap<>();
        return data;
        //throw new NullPointerException();
    }
}
