package com.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserById(){
        System.out.println("get.....");
        return "user";
    }
    public void deleteUserById(){
        System.out.println("delete....");
    }
}
