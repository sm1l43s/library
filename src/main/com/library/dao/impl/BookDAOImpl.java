package main.com.library.dao.impl;

import main.com.library.dao.IBookDAO;
import main.com.library.entity.Author;
import main.com.library.entity.Book;
import main.com.library.entity.Genres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements IBookDAO<Integer, Book> {

    private final String SQL_SELECT_ALL =
            "SELECT * FROM books";

    private final String SQL_SELECT_BOOK_BY_ID =
            "SELECT * FROM books WHERE b_id = ?";

    private final String SQL_UPDATE_BOOK =
            "UPDATE books SET b_name = ?, b_year = ?, b_quantity = ? WHERE b_id = ?";

    private final String SQL_INSERT_BOOK =
            "INSERT INTO books(b_id, b_name, b_year, b_quantity) VALUES(?, ?, ?, ?)";

    private final String SQL_DELETE_BOOK =
            "DELETE FROM books WHERE b_id = ?";

    private final String SQL_SELECT_ALL_BOOKS_BY_AUTHOR =
            "SELECT  books.b_id, books.b_name, \n" +
                    "books.b_year, books.b_quantity\n" +
                    "FROM m2m_books_authors \n" +
                    "INNER JOIN books ON m2m_books_authors.b_id = books.b_id \n" +
                    "WHERE a_id = ?;";

    private final String SQL_SELECT_ALL_BOOKS_BY_GENRES =
            "SELECT books.b_id, books.b_name, \n" +
                    "books.b_year, books.b_quantity\n" +
                    "FROM library.m2m_books_genres\n" +
                    "INNER JOIN books ON m2m_books_genres.b_id = books.b_id\n" +
                    "WHERE m2m_books_genres.g_id = ?";


    private final Connection connection;

    public BookDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                books.add(extractBookFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book findById(Integer id) {
        Book book;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_SELECT_BOOK_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            book = extractBookFromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public boolean delete(Book book) {
        int isDelete;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_DELETE_BOOK)) {
            statement.setInt(1, book.getId());
            isDelete = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete > 0;
    }

    @Override
    public boolean create(Book book) {
        int isAdd;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_INSERT_BOOK)) {
            statement.setInt(1, book.getId());
            statement.setString(2, book.getName());
            statement.setLong(3, book.getYearPublish());
            statement.setInt(4, book.getQuantity());
            isAdd = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd > 0;
    }

    @Override
    public Book update(Book book) {
        Book newBook;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_UPDATE_BOOK)) {
            statement.setString(1, book.getName());
            statement.setLong(2, book.getYearPublish());
            statement.setInt(3, book.getQuantity());
            statement.setInt(4, book.getId());
            statement.execute();
            newBook = findById(book.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newBook;
    }

    @Override
    public List<Book> findAllBooksByAuthor(Author author) {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_SELECT_ALL_BOOKS_BY_AUTHOR)) {
            statement.setInt(1, author.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                books.add(extractBookFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public List<Book> findAllBooksByGenres(Genres genres) {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_SELECT_ALL_BOOKS_BY_AUTHOR)) {
            statement.setInt(1, genres.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                books.add(extractBookFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    private Book extractBookFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("b_id");
        String name = resultSet.getString("b_name");
        Long year = resultSet.getLong("b_year");
        int quantity = resultSet.getInt("b_quantity");

        return new Book(id, name, year, quantity);
    }
}
