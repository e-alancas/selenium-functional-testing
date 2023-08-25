package org.ealancas.test;

import org.ealancas.functionaltesting.browsers.Browser;
import org.ealancas.functionaltesting.browsers.BrowserFactory;

import org.testng.annotations.Test;

public class TestBrowser {

    @Test(groups={"orderBo", "save"})
    public void testChromeInit() throws InterruptedException{
        Browser chrome = new BrowserFactory().getBrowser("CHROME");
        chrome.getDriver().get("https://www.google.com");
        Thread.sleep(5000);
        chrome.getDriver().quit();
    }
}