package com.example.user.service;

import com.example.commonsdata.usersData.OnboardUserDto;
import com.example.user.data.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface UserService {

    String onboardAdminUser();

    String sendDefaultMessage();

    List<OnboardUserDto> getAllUsers();
    
    Map<String,Object> checkUserAuth(String userName, String checkSum);

    Page<User> getUserPage(Integer pageNum, Integer size);

    Page<User> getUserPageObj(Pageable pageable);
}
