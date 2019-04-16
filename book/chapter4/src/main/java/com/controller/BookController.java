package com.controller;

import com.Author;
import com.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String addBook(String name){
        return "receive:"+name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id){
        return String.valueOf(id);
    }


//    @GetMapping("/bookes")
//    public Book book(){
//        Book book=new Book();
//        book.setAuthor("罗贯中");
//        book.setName("三国演义");
//        book.setPrice(30f);
//        book.setPubliccationDate(new Date());
//        return book;
//    }


//    @GetMapping(value = "/hello")
//    @ResponseBody
//    public void hello(Model model){
//        Map<String,Object> map=model.asMap();
//        Set<String> keyset=map.keySet();
//        Iterator<String> iterator=keyset.iterator();
//        while(iterator.hasNext()){
//            String key=iterator.next();
//            Object value=map.get(key);
//            System.out.println(key+">>>>>>"+value);
//        }
//
//    }


//    @GetMapping(value = "/book")
//    @ResponseBody
//    public  String book(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author){
////        book.setName("三国演义");
////        author.setName("罗贯中");
//        return book.toString()+">>>>>"+author.toString();
//    }


//    @GetMapping(value = "/book")
//    @ResponseBody
//    public  String book( Book book,  Author author){
////        book.setName("三国演义");
////        author.setName("罗贯中");
//        return book.getName()+">>>>>"+author.getName();
//    }
}
