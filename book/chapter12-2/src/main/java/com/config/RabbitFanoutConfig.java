package com.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig {

    public final static String DIRECTNAME="sang_direct";
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(DIRECTNAME,true,false);
    }
    @Bean
    Queue queue(){
        return new Queue("hello-queue");
    }
        @Bean
        Binding binding(){
        return BindingBuilder.bind(queue())
                .to(directExchange()).with("direct");
    }
}
