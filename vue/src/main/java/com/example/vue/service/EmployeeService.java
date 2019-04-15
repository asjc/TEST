package com.example.vue.service;

import com.example.vue.dao.all.EmployeeDao;
import com.example.vue.dao.employee.EmployeeMapper;
import com.example.vue.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    EmployeeDao employeeDao;
    public int getMaxWorkID() {
        return employeeMapper.getMaxWorkID();
    }
    public List<Employee> employeeList(Integer page, Integer size, String keywords, Integer politicId, Integer nationId, Integer posId, Integer jobLevelId, String engageForm, Integer departmentId, String beginDateScope){
        Date startBeginDate = null;
        Date endBeginDate = null;
        if (beginDateScope != null && beginDateScope.contains(",")) {
            try {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return employeeMapper.getEmployeeByPage((page-1)*size, size, keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }
    public int add(Employee employee){
        return employeeMapper.addEmp(employee);
    }
    public int addEmps(List<Employee> employees){
        return employeeMapper.addEmps(employees);
    }
    public int count(String keywords, Integer politicId, Integer nationId, Integer posId, Integer jobLevelId, String engageForm, Integer departmentId, String beginDateScope) {
        Date startBeginDate = null;
        Date endBeginDate = null;
        if (beginDateScope != null && beginDateScope.contains(",")) {
            try {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return employeeMapper.getCountByKeywords(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }
}