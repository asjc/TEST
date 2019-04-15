package com.example.vue.dao.all;

import com.example.vue.pojo.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Integer> {
}
