package com.example.vue.dao.all;

import com.example.vue.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
