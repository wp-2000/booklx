package com.wp.service;

import com.wp.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void del(int bookId);

    void add(Book book);

    Book findOne(int bookId);

    void update(Book book);
}
