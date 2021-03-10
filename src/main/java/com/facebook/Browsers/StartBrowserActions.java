package com.facebook.Browsers;

import com.facebook.utils.PageHandler;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class StartBrowserActions {
    WebDriver driver;

    public WebDriver openBrowser(String browserName, String Url) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeBrowser().getDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Url);
        return driver;
    }
}
