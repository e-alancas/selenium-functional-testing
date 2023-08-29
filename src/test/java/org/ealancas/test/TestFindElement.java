package org.ealancas.test;

import org.ealancas.functionaltesting.browsers.Browser;
import org.ealancas.functionaltesting.browsers.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestFindElement {
    WebElement searchCta;


    @Test(groups={"orderBo", "save"})
    public void testFindElementByCssSelector() {
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        chrome.getDriver().get("https://www.google.com");
        searchCta = chrome.getDriver().findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)"));
        chrome.getDriver().quit();
    }

    @Test(groups={"orderBo", "save"})
    public void testFindElementXpath() {
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        chrome.getDriver().get("https://www.google.com");
        searchCta = chrome.getDriver().findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        chrome.getDriver().quit();
    }

    @Test(groups={"orderBo", "save"})
    public void testFindElementName() {
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        chrome.getDriver().get("https://www.google.com");
        searchCta = chrome.getDriver().findElement(By.name("btnK"));
        chrome.getDriver().quit();
    }
}