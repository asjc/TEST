package com.service;

import com.dao.BookDao;
import com.entity.Book;
import com.mapper.BookMapper;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
//@MapperScan("com.mapper" )
public class BookService {
    /*@Autowired*/
//    @Resource
//    BookMapper2 bookMapper;
//    @Autowired
//    BookDao bookDao;
//
//    public void addBook(Book book){
//        bookDao.save(book);
//    }
//
//    public Page<Book> getBookByPage(Pageable pageable){
//        return bookDao.findAll(pageable);
//    }
//    public List<Book> getBooksByAuthor(String author){
//        return bookDao.getBooksByAuthor(author);
//    }
//    public List<Book> getBooksByPrice(Float price){
//        return bookDao.getBooksByPrice(price);
//    }
//    public Book getMaxIdBook(){
//        return bookDao.getMaxIdBook();
//    }
//
//    public List<Book> getBookByIdAndAuthor(String author,Integer id){
//        return bookDao.getBookByIdAndAuthor(author,id);
//    }
//    public List<Book> getBooksByAndName(String name,Integer id){
//        return bookDao.getBooksByIdAndName(name,id);
//    }

//    public int addBook(Book book){
//        return bookMapper.addBook(book);
//    }
//
//    public int updateBook(Book book){
//        return bookMapper.updateBookById(book);
//    }
//
//    public int deleteBookById(int id){
//        return bookMapper.deleteBookById(id);
//    }
//
//    public Book getBookById(int id){
//        return bookMapper.getBookById(id);
//    }
//    public List<Book> getAllBooks(){
//        return bookMapper.getAllBooks();
//    }
}
