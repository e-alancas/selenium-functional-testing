package org.ealancas.functionaltesting.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <h2>ReadProperties</h2>
 * The ReadProperties class contains the logic to read and store
 * the properties file according to the appEnv var passed via
 * the test Maven command.
 * <p>
 *
 * @author Eliecer Alan
 * @author ealancascante@gmail.com
 * @author <a href="https://github.com/e-alancas">GitHub profile</a>
 * @version 1.0
 * @since 2023-08-25
 */
public class ReadProperties {

    private static final Logger logger = LogManager.getLogger(ReadProperties.class);
    private String propertiesPath = this.getPropertiesPath();
    private Properties properties = new Properties();
    private static final ReadProperties instance;

    static {
        try {
            instance = new ReadProperties();
        } catch (IOException e) {
            logger.error(e.getMessage());
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
        properties.forEach((key, value) -> logger.info("Properties.toString: Key : " + key + ", Value : " + value));
        return "";
    }

    private String getPropertiesPath() {
        String appEnv = System.getProperty("app.env", "local");

        logger.info("Provided appEnv: " + appEnv);

        switch (appEnv) {
            case "ci":
                logger.info("Set path for properties at: src/main/resources/ci/ci.properties");
                return "src/main/resources/ci/ci.properties";
            default:
                logger.info("Set path for properties at: src/main/resources/local/local.properties");
                return "src/main/resources/local/local.properties";
        }
    }
}
