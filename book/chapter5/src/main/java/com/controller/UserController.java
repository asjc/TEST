package com.controller;

import com.dao1.UserDao1;
import com.dao2.UserDao2;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserDao1 userDao1;
    @Autowired
    UserDao2 userDao2;

    @GetMapping("/usertest")
    public void usertest(){
        User u1=new User();
        u1.setAge(55);
        u1.setName("鲁迅");
        u1.setGender("男");
        userDao1.save(u1);
        User u2=new User();
        u2.setAge(60);
        u2.setName("泰戈尔");
        u2.setGender("男");
        userDao2.save(u2);
    }

}
