package com.example.vue.util.security;


import com.example.vue.dao.menu.MenuMapper;
import com.example.vue.pojo.Menu;
import com.example.vue.pojo.Role;
import com.example.vue.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class Custom implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    MenuService menuService;
    @Autowired
    MenuMapper menuMapper;
    /**
     * 根据请求Url获取所需要角色权限
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址信息
        String requestURL = ((FilterInvocation) o).getRequestUrl();
        //获取菜单资源
            List<Menu> menuList = menuMapper.getAllMenus();
        //循环进行对比
        for (Menu menu : menuList) {
            if (antPathMatcher.match(menu.getUrl(), requestURL)) {
                List<Role> roles = menu.getRoles();
                String[] roleArr = new String[roles.size()];
                for (int i = 0; i < roleArr.length; i++) {
                    roleArr[i] = roles.get(i).getName();
                }
                //返回所需要的角色
                return SecurityConfig.createList(roleArr);
            }
        }
        //没有请求成功,默认登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}