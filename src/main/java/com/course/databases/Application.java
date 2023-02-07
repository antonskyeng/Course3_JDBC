package com.course.databases;

import com.course.databases.DAO.BookDAO;
import com.course.databases.DAO.BookDAOImpl;
import com.course.databases.model.Author;
import com.course.databases.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        BookDAO bookDAO = new BookDAOImpl();
        Book book1 = new Book("Taras Bulba", 2, 22);
        bookDAO.create(book1);

        System.out.println(bookDAO.readById(11));

        List<Book> list = bookDAO.readAll();

        for (Book book : list) {
            System.out.println(book);
        }

        Book book2 = new Book(5, "Ruslan and Ludmila", 3, 11);

        bookDAO.updateAmount(book2);

        bookDAO.delete(book2);

    }
}














/*

        final String user = "postgres";
        final String password = "5833118";
        final String url = "jdbc:postgresql://localhost:5432/skypro";


        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("" +
                     "SELECT * FROM book WHERE book_id = (?)")) {

            statement.setInt(1, 6);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String titleOfBook = "Title: " + resultSet.getString("title");
                String authorOfBook = "Author_id: " + resultSet.getString("author_id");
                int amountOfBook = resultSet.getInt(4);

                System.out.println(titleOfBook);
                System.out.println(authorOfBook);
                System.out.println("Amount: " + amountOfBook);

            }
        }
 */



/*
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("" +
                     "SELECT * FROM book WHERE book_id = (?)")) {

            statement.setInt(1, 6);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String titleOfBook = "Title: " + resultSet.getString("title");
                String authorOfBook = "Author_id: " + resultSet.getString("author_id");
                int amountOfBook = resultSet.getInt(4);

                System.out.println(titleOfBook);
                System.out.println(authorOfBook);
                System.out.println("Amount: " + amountOfBook);

            }
        }
 */


/*


        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            BookDAO bookDAO = new BookDAOImpl(connection);

            Author author = new Author(1, "L.N.Tolstoy");
            Book book1 = new Book("Anna Karenina", author, 6);

            bookDAO.create(book1);

            List<Book> list = new ArrayList<>(bookDAO.readAll());

            for (Book book : list) {
                System.out.println(book);
            }
 */


//        Connection connection = DriverManager.getConnection(url, user, password);
//        BookDAO bookDAO = new BookDAOImpl(connection);
//
//        Author author = new Author(1, "L.N.Tolstoy");
//
//        Book book1 = new Book("Anna Karenina", author, 6);
//
////        List<Book> list = new ArrayList<>(bookDAO.readAll());
////
////        for (Book book : list) {
////            System.out.println(book);
////        }
//
//
//
//        try {
////            System.out.println(bookDAO.readById());
////
////            bookDAO.updateAmountById(6, 10);
////
////            System.out.println(bookDAO.readById(6));
//            List<Book> list = new ArrayList<>(bookDAO.readAll());
//
//            for (Book book : list) {
//                System.out.println(book);
//            }
//
//            System.out.println("_______________________");
//
//            bookDAO.deleteById(9);
//
//            list = new ArrayList<>(bookDAO.readAll());
//
//            for (Book book : list) {
//                System.out.println(book);
//            }
//
//
////            bookDAO.create(book1);
//        } finally {
//            connection.close();
//        }


//    }
//}




//        try (final Connection connection = DriverManager.getConnection(url, user, password);
//                PreparedStatement statement = connection.prepareStatement("" +
//                        "SELECT * FROM book WHERE book_id = (?)")) {
//
//            statement.setInt(1, 6);
//            final ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                String titleOfBook = "Title: " + resultSet.getString("title");
//                String authorOfBook = "Author_id: " + resultSet.getString("author_id");
//                int amountOfBook = resultSet.getInt(4);
//
//                System.out.println(titleOfBook);
//                System.out.println(authorOfBook);
//                System.out.println("Amount: " + amountOfBook);
//
//            }
