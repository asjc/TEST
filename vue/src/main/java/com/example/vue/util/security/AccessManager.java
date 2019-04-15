package com.example.vue.util.security;


import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AccessManager implements AccessDecisionManager {

    /**
     * 判断用户是否具有请求访问所需要的权限
     * @param auth
     * @param object
     * @param ca
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication auth, Object object, Collection<ConfigAttribute> ca) throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> auths=auth.getAuthorities();
        for (ConfigAttribute configAttribute:ca){
            if ("ROLE_LOGIN".equals(configAttribute.getAttribute())){
                if(auth instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                }else{
                    return;
                }
            }
            for (GrantedAuthority authority:auths){
                if(configAttribute.getAttribute().equals(authority.getAuthority())){
                    return;
                }
            }
        }
        //抛出异常权限不足
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}