package main.com.library.dao.impl;

import main.com.library.dao.IGenresDAO;
import main.com.library.entity.Genres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenresDAOImpl implements IGenresDAO<Integer, Genres> {

    private final String SQL_SELECT_ALL =
            "SELECT * FROM genres";

    private final String SQL_SELECT_GENRES_BY_ID =
            "SELECT * FROM genres WHERE g_id = ?";

    private final String SQL_UPDATE_GENRES =
            "UPDATE genres SET g_name = ? WHERE g_id = ?";

    private final String SQL_INSERT_GENRES =
            "INSERT INTO genres(g_id, g_name) VALUES(?, ?)";

    private final String SQL_DELETE_GENRES =
            "DELETE FROM genres WHERE g_id = ?";

    private final Connection connection;

    public GenresDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Genres> findAll() {
        List<Genres> genres = new ArrayList<>();

        try (Statement statement = this.connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);

            while (rs.next()) {
                genres.add(extractGenresFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genres;
    }

    @Override
    public Genres findById(Integer id) {
        Genres genres;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_SELECT_GENRES_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            genres = extractGenresFromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genres;
    }

    @Override
    public boolean delete(Genres genres) {
        int isDelete;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_DELETE_GENRES)) {
            statement.setInt(1, genres.getId());
            isDelete = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete > 0;
    }

    @Override
    public boolean create(Genres genres) {
        int isAdd;

        try (PreparedStatement statement = this.connection.prepareStatement(SQL_INSERT_GENRES)) {
            statement.setInt(1, genres.getId());
            statement.setString(2, genres.getName());
            isAdd = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd > 0;
    }

    @Override
    public Genres update(Genres genres) {
        Genres newGenres;

        try (PreparedStatement statement = this.connection.prepareStatement(SQL_UPDATE_GENRES)) {
            statement.setString(1, genres.getName());
            statement.setInt(2, genres.getId());
            statement.execute();
            newGenres = findById(genres.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return newGenres;
    }

    private Genres extractGenresFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("g_id");
        String name = resultSet.getString("g_name");

        return new Genres(id, name);
    }
}
