package org.sang.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
    @RequestMapping("/hello")
    public String index(){
        return "hello boot !";
    }
}
