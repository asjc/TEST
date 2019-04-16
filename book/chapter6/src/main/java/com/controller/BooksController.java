package com.controller;

import com.dao.BookDao;
import com.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BookDao bookDao;
    @GetMapping("/test")
    public void test(){
        List<Book> books=new ArrayList<>();
        Book b1=new Book();
        b1.setId(3);
        b1.setName("红楼梦");
        b1.setAuthor("曹雪芹");
        books.add(b1);
        Book b2=new Book();
        b2.setId(4);
        b2.setName("三国演义");
        b2.setAuthor("罗贯中");
        books.add(b2);
        bookDao.insert(books);
        List<Book> books1=bookDao.findByAuthorContains("曹雪芹");
        System.out.println(books1);
        Book book=bookDao.findByNameEquals("三国演义");
        System.out.println(book);
    }

}
