package org.ealancas.functionaltesting.screenshots;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ealancas.functionaltesting.properties.ReadProperties;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * <h2>BrowserScreenshot</h2>
 * The BrowserScreenshot class is a singleton class for an unique instance to take screenshots by
 * using the driver.
 * <p>Usage example:</p>
 * <pre>{@code
 *     // Create a Chrome instance
 *     Driver driver = new BrowserFactory().getBrowser("chrome");
 *
 *     // Go to Google search page
 *     driver.getDriver().get("https://google.com");
 *
 *     // Create a browser screenshot object and take the screenshot
 *     BrowserScreenshot bs = BrowserScreenshot.getInstance();
 *     bs.getFullScreenshot(driver.getDriver(), "main");
 *
 *     // Close the driver
 *     driver.getDriver().close();
 * }</pre>
 *
 * <p>
 *
 * @author Eliecer Alan
 * @author ealancascante@gmail.com
 * @author <a href="https://github.com/e-alancas">GitHub profile</a>
 * @version 1.0
 * @since 2023-09-04
 */

public class BrowserScreenshot {
    private static final Logger logger = LogManager.getLogger(ReadProperties.class);
    private final Properties properties = ReadProperties.getInstance().getProperties();
    private static final BrowserScreenshot instance;
    private final String outputPath = properties.getProperty("screenshot.output.path");
    private final String imagePrefix = properties.getProperty("screenshot.image.prefix");
    private final String imageFormat = properties.getProperty("screenshot.image.format");
    private final String dateFormat = properties.getProperty("screenshot.output.dateformat");
    private final int scrollTimeout = Integer.parseInt(properties.getProperty("screenshot.scroll.timeout"));
    private final float dpr = Float.parseFloat(properties.getProperty("screenshot.output.dpr"));

    static {
        instance = new BrowserScreenshot();
    }

    public static BrowserScreenshot getInstance() {
        return instance;
    }

    /**
     *
     * @param driver Selenium WebDriver instance
     * @param className Classname where this will be invoked from
     * @return WebDriver instance passed via params
     * @throws IOException
     */
    public WebDriver getFullScreenshot(WebDriver driver, String className) throws IOException {
        Files.createDirectories(Paths.get(outputPath));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime localDate = LocalDateTime.now();
        Screenshot screenshot = new AShot().shootingStrategy(
                ShootingStrategies.viewportPasting(
                        ShootingStrategies.scaling(dpr), scrollTimeout)
        ).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),
                imageFormat,
                new File(outputPath +
                        imagePrefix +
                        className +
                        " " +
                        dtf.format(localDate) +
                        "." +
                        imageFormat)
        );
        return driver;
    }
}
