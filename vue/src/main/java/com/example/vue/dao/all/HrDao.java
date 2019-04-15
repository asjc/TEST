package com.example.vue.dao.all;

import com.example.vue.pojo.Hr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrDao extends JpaRepository<Hr,Integer> {
    Hr findHrByUsername(String username);
}
