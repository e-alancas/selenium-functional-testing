package org.ealancas.functionaltesting.browsers;

import java.util.Properties;

import org.ealancas.functionaltesting.properties.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * <h2>Chrome</h2>
 * The Chrome class is part of the simple factory pattern
 * applied to create and manage multiple browsers such as chrome
 * and others.
 * <p>
 * Contains the specific configurations and handling of the Google Chrome
 * WebDriver
 *
 *
 * @author Eliecer Alan
 * @author ealancascante@gmail.com
 * @author <a href="https://github.com/e-alancas">GitHub profile</a>
 * @version 1.1
 * @since 2023-09-03
 */

public class Chrome implements Browser {
    private WebDriver driver;
    private Properties properties = ReadProperties.getInstance().getProperties();
    private ChromeOptions options = new ChromeOptions();
    public Chrome() {
        if (Boolean.valueOf(properties.getProperty("selenium.chrome.headless"))) options.addArguments("--headless=new");
        System.setProperty("webdriver.chrome.driver", properties.getProperty("selenium.chrome.path"));
        driver = new ChromeDriver(options);
        if (Boolean.valueOf(properties.getProperty("selenium.chrome.maximize"))) this.maximizeWindow();
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
