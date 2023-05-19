package com.example.documentservice.service.impl;

import com.example.documentservice.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    @Override
    public Map<String, String> uploadSingleFile(MultipartFile file) {
        log.info("inside uploadSingleFile with fileName {}", file.getOriginalFilename());
        Map<String, String> resultMap = new HashMap<>();
        try {
            String fileName = file.getOriginalFilename();
            file.transferTo(new File("/" + fileName));
            resultMap.put("FileName", fileName);
            resultMap.put("Status", "Success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultMap;
    }
}
