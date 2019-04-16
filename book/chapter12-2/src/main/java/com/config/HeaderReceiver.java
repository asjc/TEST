package com.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HeaderReceiver {
    @RabbitListener(queues = "name-queue")
    public void hander1(byte[] msg){
        System.out.println("HanderReceiver:name:"+new String(msg,0,msg.length));
    }
    @RabbitListener(queues = "age-queue")
    public void hander2(byte[] msg){
        System.out.println("HanderReceiver:age:"+new String(msg,0,msg.length));
    }



}
