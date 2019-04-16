package com.config;

import com.rabbitmq.client.impl.AMQImpl;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirectConfig {
    public final static String FANOUTNAME="sang_fanout";
        @Bean
        FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUTNAME,true,false);
    }
    @Bean
    Queue queueOne(){
        return new Queue("queue-one");
    }

    @Bean
    Queue queueTwo(){
        return new Queue("queue-two");
    }

    @Bean
    Binding bindingOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo(){
            return  BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }



//
//    @Bean
//    Binding binding(){
//        return BindingBuilder.bind(queue())
//                .to(directExchange()).with("direct");
//    }


}
