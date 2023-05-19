package com.example.message.messageservice.service.impl;

import com.example.commonsdata.usersData.OnboardUserDto;
import com.example.message.messageservice.data.History;
import com.example.message.messageservice.repository.HistoryRepo;
import com.example.message.messageservice.service.HistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private HistoryRepo historyRepo;

    @Override
    public List<History> getAllHistory() {
        return historyRepo.findAll();
    }

    @KafkaListener(topics = "USER-ACTIVITY",groupId = "userGroup")
    public void consumeOnboardUserMessage(OnboardUserDto onboardUserDto){
        log.info("Inside consumeOnboardUserMessage with value === {}",onboardUserDto);
        History history=new History();
        history.setHistoryCategory(History.HistoryCategory.LOGIN);
        history.setUserNo(onboardUserDto.getUserNo());
        history.setCreatedDate(new Date());
        history.setMessage("Admin User Created Successfully");
        historyRepo.save(history);
    }
}
