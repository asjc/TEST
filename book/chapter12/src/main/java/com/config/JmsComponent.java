package com.config;

import com.entity.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.jms.Queue;

@Component
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate messagingTemplate;
    @Autowired
    Queue queue;
    public void send(Messages msg){
        messagingTemplate.convertAndSend(this.queue,msg);
    }

    @JmsListener(destination = "amq")
    public void receive(Messages msg){
        System.out.println("receive:"+msg);
    }
}
