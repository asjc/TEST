package com.example.vue.controller;

import com.example.vue.pojo.Menu;
import com.example.vue.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu(){
        return menuService.getMenusByHrId();
    }
}
