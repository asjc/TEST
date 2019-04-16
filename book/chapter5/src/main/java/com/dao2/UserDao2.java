package com.dao2;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDao2 extends JpaRepository<User,Integer> {
}
