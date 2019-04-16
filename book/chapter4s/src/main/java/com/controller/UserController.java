package com.controller;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getUserById")
    public String getUserById(){
        return userService.getUserById();
    }

    @GetMapping("/deleteUserById")
    public void deleteUserById(){
         userService.deleteUserById();
    }

}
