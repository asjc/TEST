package com;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;
@Component
@Configuration
@ConfigurationProperties("spring.redis.cluster")
public class RedisConfig {
    List<Integer> ports;
    String host;
    JedisPoolConfig poolConfig;
    @Bean
    RedisClusterConfiguration redisClusterConfiguration(){
        RedisClusterConfiguration configuration=new RedisClusterConfiguration();
        List<RedisNode> nodes=new ArrayList<>();
        for (Integer port:ports){
            nodes.add(new RedisNode(host,port));
        }
        configuration.setPassword(RedisPassword.of("1111"));
        configuration.setClusterNodes(nodes);
        return configuration;
    }




}
