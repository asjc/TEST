package com.example.vue.service;


import com.example.vue.dao.menu.MenuMapper;
import com.example.vue.pojo.Menu;
import com.example.vue.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenus();
    }
    public List<Menu> getMenusByHrId(){
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }
}
