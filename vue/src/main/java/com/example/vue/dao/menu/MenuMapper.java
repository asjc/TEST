package com.example.vue.dao.menu;

import com.example.vue.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getAllMenus();
    List<Menu> getMenusByHrId(int hrId);
}
