package main.com.library.dao;

import main.com.library.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthorDAOImpl implements IAuthorDAO<Integer, Author> {

    private final Connection connection;

    private final String SQL_SELECT_ALL =
            "SELECT * FROM authors";

    private final String SQL_SELECT_AUTHOR_BY_ID =
            "SELECT * FROM authors WHERE a_id = ?";

    private final String SQL_UPDATE_AUTHOR =
            "UPDATE authors SET a_name = ? WHERE a_id = ?";

    private final String SQL_INSERT_AUTHOR =
            "INSERT INTO authors(a_id, a_name) VALUES(?, ?)";

    private final String SQL_DELETE_AUTHOR =
            "DELETE FROM authors WHERE a_id = ?";

    public AuthorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();

        try (Statement statement = this.connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);

            while (rs.next()) {
                int id = rs.getInt("a_id");
                String name = rs.getString("a_name");
                authors.add(new Author(id, name, Collections.EMPTY_LIST));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return authors;
    }

    @Override
    public Author findById(Integer id) {
        Author author = null;

        try (PreparedStatement statement = this.connection.prepareStatement(SQL_SELECT_AUTHOR_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int a_id = rs.getInt("a_id");
                String name = rs.getString("a_name");
                author = new Author(a_id, name, Collections.EMPTY_LIST);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return author;
    }

    @Override
    public boolean delete(Author author) {
        int isDelete;

        try (PreparedStatement statement = this.connection.prepareStatement(SQL_DELETE_AUTHOR)) {
            statement.setInt(1, author.getId());
            isDelete = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete > 0;
    }

    @Override
    public boolean create(Author author) {
        int isAdd;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_INSERT_AUTHOR)) {
            statement.setInt(1, author.getId());
            statement.setString(2, author.getName());
            isAdd = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd > 0;
    }

    @Override
    public Author update(Author author) {
        Author newAuthor;

        try (PreparedStatement statement = this.connection.prepareStatement(SQL_UPDATE_AUTHOR)) {

            statement.setString(1, author.getName());
            statement.setInt(2, author.getId());

            statement.execute();
            newAuthor = findById(author.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return newAuthor;
    }
}
