package com.dao;

import com.entity.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
//@CacheConfig(cacheNames = "book_cache")
public class BookDao {
//    @Cacheable(value ="c1" )
//    public Book getBookById(int id){
//        System.out.println("getBookById");
//        Book book=new Book();
//        book.setId(id);
//        book.setName("三国演义");
//        book.setAuthor("罗贯中");
//        return book;
//
//    }

//    @CachePut(key = "#book.id")
//    public Book updateBookById(Book book){
//        System.out.println("updateBookById");
//        book.setName("三国演义2");
//        return book;
//    }

//    @CacheEvict(key = "#id")
//    public  void deleteBookById(Integer id){
//        System.out.println("deleteBookById");
//    }


    @Cacheable(value ="c1" )
    public String getBookById(Integer id){
        System.out.println("getBookById");
        return "这本书是三国演义";
    }

    @CachePut(value = "c1")
    public String updateBookById(Integer id){
        return "这是全新的三国演义";
    }

    @CacheEvict(value = "c1")
    public  void deleteById(Integer id){
        System.out.println("deleteBookById");
    }

    @Cacheable(value ="c2" )
    public String getBookById2(Integer id){
        System.out.println("getBookById");
        return "这本书是三国演义";
    }


}
