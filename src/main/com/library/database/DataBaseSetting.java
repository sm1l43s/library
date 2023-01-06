package main.com.library.database;

import java.util.Properties;

public class DataBaseSetting {

    private String url;
    private String dbName;
    private String user;
    private String password;
    private String dbDriver;

    public DataBaseSetting (Properties properties) {
        this.url = properties.getProperty("db.url");
        this.dbName = properties.getProperty("db.name");
        this.user = properties.getProperty("db.user");
        this.password = properties.getProperty("db.password");
        this.dbDriver = properties.getProperty("db.Driver");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }
}
