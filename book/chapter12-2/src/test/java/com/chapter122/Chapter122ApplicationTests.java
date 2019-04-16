package com.chapter122;

import com.config.RabbitDirectConfig;
import com.config.RabbitFanoutConfig;
import com.config.RabbitHeaderConfig;
import com.config.RabbitTopcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter122ApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    public void topicTest(){
        rabbitTemplate.convertAndSend(RabbitTopcConfig.TOPICNAME,"xiaomi.news","小米新闻..");
        rabbitTemplate.convertAndSend(RabbitTopcConfig.TOPICNAME,"huawui.news","华为新闻..");
        rabbitTemplate.convertAndSend(RabbitTopcConfig.TOPICNAME,"xiaomi.phone","小米手机..");
        rabbitTemplate.convertAndSend(RabbitTopcConfig.TOPICNAME,"huawui.phone","华为手机..");
        rabbitTemplate.convertAndSend(RabbitTopcConfig.TOPICNAME,"phone.news","手机新闻..");

    }


    @Test
    public void contextLoads1() {
        rabbitTemplate.convertAndSend(RabbitDirectConfig.FANOUTNAME,null,"hello fanout!");
    }

    @Test
    public void contextLoads2() {
        rabbitTemplate.convertAndSend("hello-queue","hello direct!");
    }

    @Test
    public void headerTest(){
        Message nameMsg=MessageBuilder.withBody("hello header! name-queue".getBytes()).setHeader("name","sang").build();
        Message ageMsg=MessageBuilder.withBody("hello header! age-queue".getBytes()).setHeader("age","99").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEEDERNAME,null,ageMsg);
        rabbitTemplate.send(RabbitHeaderConfig.HEEDERNAME,null,nameMsg);

    }


}
