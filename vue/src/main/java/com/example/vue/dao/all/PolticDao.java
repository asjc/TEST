package com.example.vue.dao.all;

import com.example.vue.pojo.PoliticsStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolticDao extends JpaRepository<PoliticsStatus,Integer> {
}
