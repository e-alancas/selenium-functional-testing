package org.ealancas.functionaltesting.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private String propertiesPath = "src/main/resources/config.properties";
    private Properties properties = new Properties();
    private static final ReadProperties instance;

    static {
        try {
            instance = new ReadProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ReadProperties() throws IOException {
        InputStream input = new FileInputStream(propertiesPath);
        properties.load(input);
    }

    public Properties getProperties() {
        return properties;
    }

    public static ReadProperties getInstance() {
        return instance;
    }

    public String toString() {
        properties.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));
        return "";
    }
}
