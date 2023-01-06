package main.com.library.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ConnectionPool {

    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);

    int getSize();

    List<Connection> getConnectionPool();
    String getUrl();
    String getUser();
    String getPassword();

    void shutdown() throws SQLException;
}
