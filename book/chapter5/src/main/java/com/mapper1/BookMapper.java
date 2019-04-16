package com.mapper1;

import com.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper {
    List<Book> getAllBooks();
}
