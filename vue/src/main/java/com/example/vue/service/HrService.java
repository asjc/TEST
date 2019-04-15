package com.example.vue.service;

import com.example.vue.dao.all.HrDao;
import com.example.vue.dao.hr.HrMapper;
import com.example.vue.pojo.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrDao hrDao;
    @Autowired
    HrMapper hrMapper;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr=hrDao.findHrByUsername(username);
        //用户不存在抛出UsernameNotFound异常
        if (hr==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        //返回给Spirng Security框架进行密码比对操作
        hr.setRoles(hrMapper.roles(hr.getId()));
        return hr;
    }
    public List<Hr> getAllHr(int id){
        return hrMapper.getAllHr(id);
    }
}
