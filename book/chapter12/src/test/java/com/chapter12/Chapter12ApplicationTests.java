package com.chapter12;

import com.config.JmsComponent;
import com.entity.Messages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter12ApplicationTests {
    @Autowired
    JmsComponent jmsComponent;
    @Test
    public void contextLoads() {
        Messages msg=new Messages();
        msg.setContent("hello jms!");
        msg.setDate(new Date());
        jmsComponent.send(msg);
    }
}
