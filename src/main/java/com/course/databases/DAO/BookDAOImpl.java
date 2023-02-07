package com.course.databases.DAO;

import com.course.databases.config.HibernateSessionFactoryUtil;
import com.course.databases.model.Author;
import com.course.databases.model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {


    @Override
    public void create(Book book) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    @Override
    public Book readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class, id);
    }

    @Override
    public List<Book> readAll() {
        List<Book> users = (List<Book>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Book").list();
        return users;
    }

    @Override
    public void updateAmount(Book book) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        }
    }

    @Override
    public void delete(Book book) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        }
    }
}















//    @Override
//    public void create(Book book) {
//        try(PreparedStatement statement = connection.prepareStatement(Queries.INSERT.QUERY)) {
//
//            statement.setString(1, book.getTitle());
//            statement.setInt(2, book.getAuthor().getId());
//            statement.setInt(3, book.getAmount());
//
//            statement.executeQuery();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Book readById(int id) {
//
//        Book book = new Book();
//
//        try (PreparedStatement statement = connection.prepareStatement(Queries.GET.QUERY)) {
//
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                book.setId(Integer.parseInt(resultSet.getString("book_id")));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(new Author(resultSet.getInt("author_id"),
//                        resultSet.getString("name_author")));
//                book.setAmount(Integer.parseInt(resultSet.getString("amount")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return book;
//    }
//
//    @Override
//    public List<Book> readAll() {
//        List<Book> bookList = new ArrayList<>();
//
//        try(PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL.QUERY)) {
//
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//
//                int id = Integer.parseInt(resultSet.getString("book_id"));
//                String title = resultSet.getString("title");
//                Author author = new Author(resultSet.getInt("author_id"),
//                        resultSet.getString("name_author"));
//                int amount = Integer.parseInt(resultSet.getString("amount"));
//
//                bookList.add(new Book(id, title, author, amount));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return bookList;
//    }
//
//    @Override
//    public void updateAmountById(int id, int amount) {
//
//        try(PreparedStatement statement = connection.prepareStatement(Queries.UPDATE.QUERY)) {
//
//            statement.setInt(1, amount);
//            statement.setInt(2, id);
//
//            statement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//        try(PreparedStatement statement = connection.prepareStatement(Queries.DELETE.QUERY)) {
//
//            statement.setInt(1, id);
//            statement.executeQuery();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

enum Queries {
    GET("SELECT * FROM book INNER JOIN author ON book.author_id=author.author_id AND book_id=(?)"),

    GET_ALL("SELECT * FROM book INNER JOIN author ON book.author_id=author.author_id"),
    INSERT("INSERT INTO book (title, author_id, amount) VALUES ((?), (?), (?))"),
    DELETE("DELETE FROM book WHERE book_id=(?)"),
    UPDATE("UPDATE book SET amount=(?) WHERE book_id=(?)");

    String QUERY;

    Queries(String QUERY) {
        this.QUERY = QUERY;
    }
}
