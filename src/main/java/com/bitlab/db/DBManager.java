package com.bitlab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    private Connection connection;

    public DBManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/books?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public boolean addBooks(Books book) {
        boolean result = false;

        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO books (name, author, price) VALUES (?, ?, ?)");
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getPrice());
            result = statement.executeUpdate() > 0;
            statement.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public ArrayList<Books> getAllBooks() {
        ArrayList books = new ArrayList();

        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM books");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                books.add(new Books(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("author"), resultSet.getInt("price")));
            }

            statement.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return books;
    }

    public Books getBook(Long id) {
        Books book = null;

        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM books WHERE id = ? ");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book = new Books(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("author"), resultSet.getInt("price"));
            }

            statement.close();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return book;
    }
}
