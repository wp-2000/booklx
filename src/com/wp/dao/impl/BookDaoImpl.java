package com.wp.dao.impl;

import com.wp.dao.BaseDao;
import com.wp.dao.BookDao;
import com.wp.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public List<Book> findAll() {
        return super.findAll("SELECT b.*,t.typeName,t.note FROM book b,bookType t WHERE b.typeId=t.typeId",Book.class);
    }

    @Override
    public void del(int bookId) {
                super.editBase("delete from book where bookId=?",bookId);
    }

    @Override
    public void add(Book book) {
                super.editBase("insert into book(bookName,price,title,bookNote,typeId) values(?,?,?,?,?)",book.getBookName(),book.getPrice(),book.getTitle(),book.getBookNote(),book.getTypeId());
    }

    @Override
    public Book findOne(int bookId) {
        return super.findOne("select b.* t.typeName from book b bookType t where b.typeId=t.typeId and bookId=?",Book.class,bookId);
    }

    @Override
    public void update(Book book) {
            super.editBase("update book set bookName=?,price=?,title=?,bookNote=?,typeId=? where bookId=?",book.getBookName(),book.getPrice(),book.getTitle(),book.getBookNote(),book.getTypeId(),book.getBookId());
    }
}
