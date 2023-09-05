package org.ealancas.functionaltesting.browsers;

import org.ealancas.functionaltesting.properties.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

/**
 * <h2>Firefox</h2>
 * The Firefox class is part of the simple factory pattern
 * applied to create and manage multiple browsers such as chrome
 * and others.
 * <p>
 * Contains the specific configurations and handling of the Firefox
 * WebDriver
 *
 *
 * @author Eliecer Alan
 * @author ealancascante@gmail.com
 * @author <a href="https://github.com/e-alancas">GitHub profile</a>
 * @version 1.0
 * @since 2023-09-03
 */

public class Firefox implements Browser {
    private WebDriver driver;
    private Properties properties = ReadProperties.getInstance().getProperties();
    private FirefoxOptions options = new FirefoxOptions();
    public Firefox() {
        if (Boolean.valueOf(properties.getProperty("selenium.firefox.headless"))) options.setHeadless(true);;
        System.setProperty("webdriver.firefox.driver", properties.getProperty("selenium.firefox.path"));
        driver = new FirefoxDriver(options);
        if (Boolean.valueOf(properties.getProperty("selenium.firefox.maximize"))) this.maximizeWindow();

    }
    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public WebDriver maximizeWindow() {
        driver.manage().window().maximize();
        return driver;
    }
}
