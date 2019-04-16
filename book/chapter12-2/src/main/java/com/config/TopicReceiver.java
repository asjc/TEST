package com.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
    @RabbitListener(queues = "phone")
    public void handlerl(String message){
        System.out.println("PhoneReceiver:"+message);
    }
    @RabbitListener(queues = "xiaomi")
    public void handler2(String message){
        System.out.println("XiaoMiReceiver:"+message);
    }
    @RabbitListener(queues = "huawui")
    public void handler3(String message){
        System.out.println("HuaWuiReceiver:"+message);
    }

}
