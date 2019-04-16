package com.controller;

import com.service.MethodService;
import com.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    MethodService methodService;
//    @GetMapping("/admin")
//    public String admin(){
//        return
//    }


    @GetMapping("/admin/hello")
    public String admin(){
        String admin=methodService.admin();
        return admin;
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user!";
    }

    @GetMapping("/db/hello")
    public String db(){
        return "hello db!";
    }

    @GetMapping("/hello")
    public String hello(){
        return methodService.admin();
    }
}
