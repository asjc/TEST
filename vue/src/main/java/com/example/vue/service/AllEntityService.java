package com.example.vue.service;

import com.example.vue.dao.all.*;
import com.example.vue.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllEntityService {
    @Autowired
    PolticDao polticDao;
    @Autowired
    NationDao nationDao;
    @Autowired
    JobLevelDao jobLevelDao;
    @Autowired
    PositionDao positionDao;
    @Autowired
    DepartmentDao departmentDao;
    public List<PoliticsStatus> getAllPolitic(){
        return polticDao.findAll();
    }
    public List<Nation> getAllNation(){
        return nationDao.findAll();
    }
    public List<JobLevel> getAllLevel(){return jobLevelDao.findAll(); }
    public List<Position> getAllPosition(){return positionDao.findAll(); }
    public List<Department> getAllDepartment(){return departmentDao.findAll();}
}
