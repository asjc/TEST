package com.dao;

import com.entity.Role;
import com.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByname(String username);
    List<Role> getUserRolesByUid(int id);
}
