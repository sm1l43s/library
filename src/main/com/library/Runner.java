package main.com.library;

import main.com.library.dao.impl.AuthorDAOImpl;
import main.com.library.database.ConnectionPoolImpl;
import main.com.library.database.DataBaseSetting;
import main.com.library.database.FilePropertiesReader;
import main.com.library.entity.Author;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ConnectionPoolImpl connectionPool;
        DataBaseSetting db =
                new DataBaseSetting(
                        new FilePropertiesReader("src/main/com/library/properties/database.properties")
                                .getProperties());

        try {
            connectionPool = ConnectionPoolImpl.create(
                    db.getUrl() + db.getDbName(),
                        db.getUser(),
                        db.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            AuthorDAOImpl authorDAO = new AuthorDAOImpl(connectionPool.getConnection());
            List<Author> authors = authorDAO.findAll();
            authors.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
