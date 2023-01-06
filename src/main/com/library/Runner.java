package main.com.library;

import main.com.library.database.ConnectionPoolImpl;
import main.com.library.database.DataBaseSetting;
import main.com.library.database.FilePropertiesReader;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        DataBaseSetting db =
                new DataBaseSetting(
                        new FilePropertiesReader("src/main/com/library/properties/database.properties")
                                .getProperties());

        try {
            ConnectionPoolImpl connectionPool = ConnectionPoolImpl.create(db.getUrl() + db.getDbName(), db.getUser(), db.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
