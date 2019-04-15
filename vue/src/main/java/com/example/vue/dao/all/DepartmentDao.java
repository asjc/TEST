package com.example.vue.dao.all;

import com.example.vue.pojo.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
