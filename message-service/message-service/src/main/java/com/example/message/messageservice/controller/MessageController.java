package com.example.message.messageservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class MessageController {

    @GetMapping(path = "/checkMessage")
    public Map<String,String> checkMessage()
    {
        Map<String,String> resMap=new HashMap<>();
        resMap.put("Status","200");
        resMap.put("result","Ok message service is upon running");
        return resMap;
    }

    @MessageMapping("/greet")
    @SendTo("/topic/greeting")
    public Map<String,String> greetUser(String userName)
    {
        log.info("Inside topic greeting");
        Map<String,String> resMap=new HashMap<>();
        resMap.put("Status","200");
        resMap.put("result","Hi "+ userName +" !");
        return resMap;
    }
}
