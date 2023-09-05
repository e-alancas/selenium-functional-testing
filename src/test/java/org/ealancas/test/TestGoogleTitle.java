package org.ealancas.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ealancas.functionaltesting.browsers.Browser;
import org.ealancas.functionaltesting.browsers.BrowserFactory;
import org.ealancas.functionaltesting.properties.ReadProperties;
import org.ealancas.functionaltesting.screenshots.BrowserScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

import java.io.IOException;

public class TestGoogleTitle {

    // Log4j2 Logger
    private static final Logger logger = LogManager.getLogger(ReadProperties.class);

    // Browser Screenshot
    private static final BrowserScreenshot browserScreenshot = BrowserScreenshot.getInstance();

    // Create all variables you may need
    private String baseUrl = "https://www.google.com";
    private WebDriver driver;
    private String expectedTitle = "Google";

    @BeforeTest
    public void launchBrowser() {
        Reporter.log("Starting Browser: Chrome", true);
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        driver = chrome.getDriver();
        Reporter.log("Go to: " + baseUrl, true);
        driver.get(baseUrl);
    }

    @Test
    public void verifyHomepageTitle() {
        String actualTitle = driver.getTitle();
        Reporter.log("Actual title: " + actualTitle, true);

        Reporter.log("Assert titles: " + actualTitle + " <=> " + expectedTitle, true);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    public void terminateBrowser() throws IOException {
        Reporter.log("Taking Screenshot", true);
        browserScreenshot.getFullScreenshot(driver, this.getClass().getSimpleName());

        Reporter.log("Closing Browser", true);
        driver.close();
    }
}
