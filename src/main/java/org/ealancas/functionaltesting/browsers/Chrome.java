package org.ealancas.functionaltesting.browsers;

import org.ealancas.functionaltesting.properties.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class Chrome implements Browser {
    private WebDriver driver;
    private Properties properties = ReadProperties.getInstance().getProperties();
    private ChromeOptions options = new ChromeOptions();
    public Chrome() {
        if (Boolean.valueOf(properties.getProperty("selenium.chrome.headless"))) options.addArguments("--headless=new");
        System.setProperty("webdriver.chrome.driver", properties.getProperty("ci.selenium.chrome.path"));
        driver = new ChromeDriver(options);
    }
    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
