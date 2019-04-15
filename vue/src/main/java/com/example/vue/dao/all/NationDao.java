package com.example.vue.dao.all;

import com.example.vue.pojo.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationDao extends JpaRepository<Nation,Integer> {
}
