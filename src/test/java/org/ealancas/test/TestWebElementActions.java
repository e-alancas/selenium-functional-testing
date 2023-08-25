package org.ealancas.test;

import org.ealancas.functionaltesting.browsers.Browser;
import org.ealancas.functionaltesting.browsers.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestWebElementActions {
    WebElement searchTextarea;
    WebElement searchCta;


    @Test(groups={"orderBo", "save"})
    public void testSendKeys() {
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        chrome.getDriver().get("https://www.google.com");
        searchTextarea = chrome.getDriver().findElement(By.cssSelector("#APjFqb"));
        searchTextarea.sendKeys("Test for send keys");
        chrome.getDriver().quit();
    }

    @Test(groups={"orderBo", "save"})
    public void testClick() {
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        chrome.getDriver().get("https://www.google.com");
        searchCta = chrome.getDriver().findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        searchCta.click();
        chrome.getDriver().quit();
    }

    @Test(groups={"orderBo", "save"})
    public void testGetText() {
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        chrome.getDriver().get("https://www.google.com");
        searchCta = chrome.getDriver().findElement(By.name("btnK"));
        String searchCtaText = searchCta.getText();
        chrome.getDriver().quit();
    }
}