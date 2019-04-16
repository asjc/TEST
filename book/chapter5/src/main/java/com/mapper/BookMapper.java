package com.mapper;
import com.entity.Book;


import java.util.List;
public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(int id);
    int updateBookById(Book book);
    Book getBookById(int id);
    List<Book> getAllBooks();
}
