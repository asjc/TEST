package com.controller;

import com.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("/test")
    public void test(){
        ValueOperations<String,String> ops1=stringRedisTemplate.opsForValue();
        ops1.set("author","三国演义");
        String name=ops1.get("author");
        System.out.println(name);
        ValueOperations ops2=redisTemplate.opsForValue();
        Book b1=new Book();
        b1.setId(1);
        b1.setName("红楼梦");
        b1.setAuthor("曹雪芹");
        ops2.set("b1",b1);
        Book b2=(Book)ops2.get("b1");
        System.out.println(b2.getAuthor());
    }

}
