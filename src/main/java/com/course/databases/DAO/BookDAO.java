package com.course.databases.DAO;

import com.course.databases.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {

    void create(Book book);
    Book readById(int id);
    List<Book> readAll();
    void updateAmount(Book book);
    void delete(Book book);

}
