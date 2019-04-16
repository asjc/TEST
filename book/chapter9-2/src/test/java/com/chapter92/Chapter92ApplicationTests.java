package com.chapter92;

import com.dao.BookDao;
import com.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter92ApplicationTests {

    @Autowired
    BookDao bookDao;
//    @Test
//    public void contextLoads() {
//        bookDao.getBookById(1);
//        bookDao.getBookById(1);
//        bookDao.deleteBookById(1);
//        Book b3=bookDao.getBookById(1);
//        System.out.println("b3:"+b3.getName()+b3.getAuthor()+b3.getId());
//        Book b=new Book();
//        b.setName("三国演义");
//        b.setAuthor("罗贯中");
//        b.setId(1);
//        bookDao.updateBookById(b);
//        Book b4=bookDao.getBookById(1);
//        System.out.println("b4:"+b4.getName()+b4.getAuthor()+b4.getId());
//    }

    @Test
    public void test(){
        bookDao.getBookById(100);
        String book=bookDao.getBookById(100);
        System.out.println(book);
        bookDao.updateBookById(100);
        String book2=bookDao.getBookById(100);
        System.out.println(book2);
        bookDao.deleteById(100);
        bookDao.updateBookById(100);
        bookDao.getBookById2(99);

    }

}
