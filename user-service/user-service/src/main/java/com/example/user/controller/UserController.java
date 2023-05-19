package com.example.user.controller;

import com.example.commonsdata.usersData.OnboardUserDto;
import com.example.user.data.User;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/onboardAdminUser")
    public String onboardAdminUser()
    {
        userService.onboardAdminUser();
       return "Success";
    }

    @GetMapping("/checkService")
    public String checkService()
    {
        return "UserService is running !!!";
    }

    @GetMapping("/sendDefaultMessage")
    public String sendDefaultMessage()
    {
        return userService.sendDefaultMessage();
    }

    @GetMapping("/getAllUsers")
    public List<OnboardUserDto> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/checkUserAuth")
    public Map<String, Object> checkUserAuth(@RequestParam("userName") String userName,@RequestParam("checkSum") String checkSum) { return userService.checkUserAuth(userName,checkSum);}

    @GetMapping ("/getUserPage")
    public Page<User> getUserPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("size") Integer size){
        return userService.getUserPage(pageNum,size);
    }

    @PostMapping ("/getUserPageObj")
    public Page<User> getUserPageObj(@RequestBody PageRequest pageable){
        return userService.getUserPageObj(pageable);
    }
}
