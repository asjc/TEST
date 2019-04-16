package com.config;

import com.dao.MenuMapper;
import com.entity.Menu;
import com.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Resource
    MenuMapper menuMapper;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl=((FilterInvocation) o).getRequestUrl();
        List<Menu> allMenus=menuMapper.getAllMenus();
        for (Menu menu:allMenus){
            if(antPathMatcher.match(menu.getPattern(),requestUrl)){
                List<Role> roles=menu.getRoles();
                String [] roleArr=new String[roles.size()];
                for (int i=0;i<roleArr.length;i++){
                    roleArr[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }

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
