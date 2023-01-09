package main.com.library.dao.impl;

import main.com.library.dao.ISubscriberDAO;
import main.com.library.entity.Subscriber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberDAOImpl implements ISubscriberDAO<Integer, Subscriber> {

    private final String SQL_SELECT_ALL =
            "SELECT * FROM subscribers";

    private final String SQL_SELECT_SUBSCRIBER_BY_ID =
            "SELECT * FROM subscribers WHERE s_id = ?";

    private final String SQL_UPDATE_SUBSCRIBER =
            "UPDATE subscribers SET s_name = ? WHERE s_id = ?";

    private final String SQL_INSERT_SUBSCRIBER =
            "INSERT INTO subscribers(s_id, s_name) VALUES(?, ?)";

    private final String SQL_DELETE_SUBSCRIBER =
            "DELETE FROM subscribers WHERE s_id = ?";

    private final Connection connection;

    public SubscriberDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> subscribers = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                subscribers.add(extractSubscriberFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subscribers;
    }

    @Override
    public Subscriber findById(Integer id) {
        Subscriber subscriber;

        try (PreparedStatement statement = this.connection.prepareStatement(SQL_SELECT_SUBSCRIBER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            subscriber = extractSubscriberFromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subscriber;
    }

    @Override
    public boolean delete(Subscriber subscriber) {
        int isDelete;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_DELETE_SUBSCRIBER)) {
            statement.setInt(1, subscriber.getId());
            isDelete = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete > 0;
    }

    @Override
    public boolean create(Subscriber subscriber) {
        int isAdd;
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_INSERT_SUBSCRIBER)) {
            statement.setString(1, subscriber.getName());
            statement.setInt(2, subscriber.getId());
            isAdd = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd > 0;
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        Subscriber newSubscriber;

        try (PreparedStatement statement = this.connection.prepareStatement(SQL_UPDATE_SUBSCRIBER)) {
            statement.setString(1, subscriber.getName());
            statement.setInt(2, subscriber.getId());

            statement.execute();
            newSubscriber = findById(subscriber.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return newSubscriber;
    }

    private Subscriber extractSubscriberFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("s_id");
        String name = resultSet.getString("s_name");

        return new Subscriber(id, name);
    }
}
