package com.example.message.messageservice.controller;

import com.example.message.messageservice.data.History;
import com.example.message.messageservice.service.HistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/history")
@Slf4j
@AllArgsConstructor
public class HistoryController {

    private HistoryService historyService;

    @GetMapping(path = "/getAllHistory")
    public List<History> getAllHistory()
    {
        return historyService.getAllHistory();
    }
}
