package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/admin/hello")
    public String admin(){

        return "admin";
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
        return "hello";
    }
}
