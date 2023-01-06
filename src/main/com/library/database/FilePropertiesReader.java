package main.com.library.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FilePropertiesReader {

    private String pathToFile;
    private Properties properties;

    public FilePropertiesReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    private void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.pathToFile);
            try {
                this.properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
