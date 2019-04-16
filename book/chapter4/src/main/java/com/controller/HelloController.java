package com.controller;

import com.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Hello hello;
    @GetMapping("/hello")
    public String hello(){
        return hello.sayHello("江南一点雨");
    }
//    @GetMapping("hellow")
//    public String hello(){
//        int i=1/0;
//        return "hello";
//    }

}
