package org.ealancas.test;

import org.ealancas.functionaltesting.properties.ReadProperties;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

//show the use of @BeforeSuite and @BeforeTest
public class TestConfig {

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("testBeforeSuite()");
        Properties props = ReadProperties.getInstance().getProperties();
    }

    @AfterSuite
    public void testAfterSuite() {
        System.out.println("testAfterSuite()");
    }

    @BeforeTest
    public void testBeforeTest() {
        System.out.println("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        System.out.println("testAfterTest()");
    }

}