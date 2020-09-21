package com.wp.service.impl;

import com.wp.dao.BookDao;
import com.wp.dao.impl.BookDaoImpl;
import com.wp.pojo.Book;
import com.wp.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao dao=new BookDaoImpl();
    @Override
    public List<Book> findAll() {
        return dao.findAll();
    }

    @Override
    public void del(int bookId) {
                dao.del(bookId);
    }

    @Override
    public void add(Book book) {
                dao.add(book);
    }

    @Override
    public Book findOne(int bookId) {
        return dao.findOne(bookId);
    }

    @Override
    public void update(Book book) {
        dao.update(book);
    }
}
