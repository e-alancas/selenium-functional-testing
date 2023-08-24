package org.ealancas.functionaltesting.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadProperties {
    private String propertiesPath = this.getPropertiesPath();
    private static final Logger logger = LogManager.getLogger(ReadProperties.class);
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
        logger.info("path: " + propertiesPath);
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

    private String getPropertiesPath() {
        String appEnv = System.getProperty("app.env", "local");
        logger.info("app env: " + appEnv);
        switch (appEnv) {
            case "ci":
                return "src/main/resources/ci/ci.properties";
            default:
                return "src/main/resources/local/local.properties";
        }
    }
}
