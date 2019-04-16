package com.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegService {
    public String reg(String username,String password){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
        String encodePassword=encoder.encode(password);
        System.out.println(encodePassword);
        return encodePassword;
    }
}
