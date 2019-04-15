package com.example.vue.dao.hr;

import com.example.vue.pojo.Hr;
import com.example.vue.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HrMapper {
    List<Role> roles(int id);
    List<Hr> getAllHr(@Param("id") int id);
}