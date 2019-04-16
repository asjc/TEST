package com.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectReceiver {
    @RabbitListener(queues = "hello-queue")
    public void handler(String msg){
        System.out.println("DirectReceiver:"+msg);
    }


}
