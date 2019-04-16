package com.controller;

import com.entity.Chats;
import com.entity.Massage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class GreetingController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Massage greeting(Massage massage) throws Exception{
        return massage;
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, Chats chat){
        String from=principal.getName();
        chat.setFrom(from);
//        System.out.println(from);
//        System.out.println(chat.getFrom()+chat.getContent());
        messagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
    }
//    public void greeting(Massage massage)throws Exception{
//        messagingTemplate.convertAndSend("/topic/greetings",massage);
//    }
}
