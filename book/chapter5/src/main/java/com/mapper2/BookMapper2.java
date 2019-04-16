package com.mapper2;

import com.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper2 {
    List<Book> getAllBooks();
}
