package com.google.foodics.tests;

import com.google.foodics.browser.Browser;
import com.google.foodics.driver.Driver;
import com.google.foodics.utils.read_properties.ReadProperties;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    protected static Browser browser = new Browser();
    public static String getBrowserName() throws IOException {
        return ReadProperties.setGoogleConfig().getProperty("browserName");
    }

    @BeforeTest(alwaysRun = true)
    protected void setUp() throws IOException {
        Driver.initDriver(getBrowserName());
        Driver.setBrowserMaximize();
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {
        Driver.closeDriver();
    }
}
