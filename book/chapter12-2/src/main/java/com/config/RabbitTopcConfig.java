package com.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopcConfig {
    public final static String TOPICNAME="sang-topic";
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPICNAME,true,false);
    }

    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }

    @Bean
    Queue huawui(){
        return new Queue("huawui");
    }
    @Bean
    Queue phone(){
        return new Queue("phone");
    }

    @Bean
    Binding xiaomiBinding(){
        return BindingBuilder.bind(xiaomi()).to(topicExchange())
                .with("xiaomi.#");
    }

    @Bean
    Binding huawuiBinding(){
        return BindingBuilder.bind(huawui()).to(topicExchange())
                .with("huawui.#");
    }
    @Bean
    Binding phoneBinding(){
        return BindingBuilder.bind(phone()).to(topicExchange())
                .with("#.phone.#");    }



}
