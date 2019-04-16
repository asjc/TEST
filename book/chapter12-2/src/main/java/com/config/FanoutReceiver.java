package com.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    @RabbitListener(queues ="queue-one")
    public void handlerl(String message){
        System.out.println("FanoutReceiver:handlerll:"+message);
    }
    @RabbitListener(queues="queue-two")
    public void handler2(String message){
        System.out.println("FanoutReceiver:handler2:"+message);
    }

}
