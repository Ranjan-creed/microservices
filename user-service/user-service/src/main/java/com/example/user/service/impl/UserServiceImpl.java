package com.example.user.service.impl;

import com.example.commonsdata.usersData.OnboardUserDto;
import com.example.user.data.User;
import com.example.user.repository.UserRepo;
import com.example.user.service.UserService;
import com.example.user.util.ChecksumUtil;
import com.example.user.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Override
    public String onboardAdminUser() {
        User user=new User();
        user.setUserName("admin");
        user.setChecksumType(User.ChecksumType.DEFAULT);
        user.setActive(true);
        user.setUserChecksum(ChecksumUtil.getEncodedCheckSum());
        String userNo=UserUtil.getUserNo();
        user.setUserNo(userNo);
        User savedUser=userRepo.save(user);
        log.info("Save User");
        publishUserData(savedUser);
        return "";
    }

    private void publishUserData(User user)
    {
        OnboardUserDto onboardUserDto=new OnboardUserDto();
        onboardUserDto.setUserName(user.getUserName());
        onboardUserDto.setUserNo(user.getUserNo());
        kafkaTemplate.send(UserUtil.USER_TOPIC,onboardUserDto);
        log.info("User Data Published Successfully");
    }

    @Override
    public String sendDefaultMessage() {
        OnboardUserDto onboardUserDto=new OnboardUserDto();
        onboardUserDto.setUserName("Default");
        onboardUserDto.setUserNo("USER_0001");
        kafkaTemplate.send(UserUtil.USER_TOPIC,onboardUserDto);
        return "Publish Success";
    }

    @Override
    public List<OnboardUserDto> getAllUsers()
    {
        List<User> userList=userRepo.findAll();
        List<OnboardUserDto> onboardUsers= new ArrayList<>();
        log.info("Inside Get all Users Data with users {} ",userList.size());
        userList.forEach(user -> {
            OnboardUserDto userDto=new OnboardUserDto();
            BeanUtils.copyProperties(user,userDto);
            onboardUsers.add(userDto);
        });

        return onboardUsers;
    }

    @Override
    public Map<String, Object> checkUserAuth(String userName, String checkSum) {
        Map<String, Object> response=new HashMap<>();
        User user= userRepo.findFirstByUserName(userName);
        if (user == null)
        {
            response.put("isSuccess",false);
            response.put("errorMsg","User Not Found");
        }else {
            String authChecksum=user.getUserChecksum();
            Boolean isMatchCheckSum=ChecksumUtil.checkUserCheckSum(authChecksum,checkSum);

            if (Boolean.TRUE.equals(isMatchCheckSum))
            {
                response.put("isSuccess", true);
                response.put("successMsg", "User Login Successfully ");
            }else {
                response.put("isSuccess", false);
                response.put("errorMsg", "Either user name or password is incorrect");
            }
        }
        return response;
    }

    @Override
    public Page<User> getUserPage(Integer pageNum, Integer size) {
        //Pagination Details
        Pageable pageable= PageRequest.of(pageNum,size, Sort.by("userId").ascending());
        Page<User> userPage=userRepo.findAll(pageable);
        return userPage;
    }

    @Override
    public Page<User> getUserPageObj(Pageable pageable) {
        Page<User> userPage=userRepo.findAll(pageable);
        return userPage;
    }


}
