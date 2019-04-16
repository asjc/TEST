package com.controller;

import com.entity.Book;
import com.mapper1.BookMapper;
import com.mapper2.BookMapper2;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {
//    @Resource(name = "jdbcTemplateOne")
//    JdbcTemplate jdbcTemplateOne;
//
//    @Autowired
//    @Qualifier("jdbcTemplateTwo")
//    JdbcTemplate jdbcTemplateTwo;

    @Resource
    BookMapper bookMapper1;
    @Resource
    BookMapper2 bookMapper2;

    @GetMapping("/test1")
    public void test1(){
        List<Book> book1=bookMapper1.getAllBooks();
        List<Book> book2=bookMapper2.getAllBooks();
        System.out.println("book1"+book1.get(0).getName());
        System.out.println("book2"+book2.get(0).getName());
    }




//    @Autowired
//    BookService bookService;
//    @GetMapping("/findAll")
//    public void findAll(){
//        PageRequest pageRequest=PageRequest.of(0,3);
//        Page<Book> page=bookService.getBookByPage(pageRequest);
//        System.out.println("总页数"+page.getTotalPages());
//        System.out.println("总记录数"+page.getTotalElements());
//        System.out.println("查询结果"+page.getContent());
//        System.out.println("当前页数"+page.getNumber());
//        System.out.println("当前页数记录书"+page.getNumberOfElements());
//        System.out.println("每页记录数"+page.getSize());
//    }
//
//    @GetMapping("/search")
//    public void search(){
//        List<Book> b1=bookService.getBookByIdAndAuthor("鲁迅",1);
//        List<Book> b2=bookService.getBooksByAuthor("吴");
//        List<Book> b3=bookService.getBooksByAndName("西",2);
//        List<Book> b4=bookService.getBooksByPrice(30F);
//        Book b=bookService.getMaxIdBook();
//        System.out.println("b1"+b1);
//        System.out.println("b2"+b2);
//        System.out.println("b3"+b3);
//        System.out.println("b4"+b4);
//        System.out.println("b"+b);
//    }
//
//    @GetMapping("/save")
//    public void save(){
//        Book book=new Book();
//        book.setAuthor("鲁迅");
//        book.setName("呐喊");
//        book.setPrice(23F);
//        bookService.addBook(book);
//    }

//    public void bookOps(){
//        Book b1=new Book();
//        b1.setName("西厢记");
//        b1.setAuthor("王实浦");
//        int i=bookService.addBook(b1);
//        System.out.println("addBook>>>"+i);
//        Book b2=new Book();
//        b2.setId(1);
//        b2.setName("朝花夕拾");
//        b2.setAuthor("鲁迅");
//        int updateBook=bookService.updateBook(b2);
//        System.out.println("updateBook>>>"+updateBook);
//        Book b3=bookService.getBookById(1);
//        System.out.println("getBookById>>>"+b3);
//        int deleteBookById=bookService.deleteBookById(6);
//        System.out.println("deleteBookById>>>"+deleteBookById);
//        List<Book> allBook=bookService.getAllBooks();
//        System.out.println("getAllBooks>>>"+allBook);
//    }
}
