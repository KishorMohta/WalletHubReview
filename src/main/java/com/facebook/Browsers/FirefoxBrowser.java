package com.facebook.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() {
        setPathForDriver();
        return new FirefoxDriver();

    }

    @Override
    public void setPathForDriver() {
        WebDriverManager.firefoxdriver().setup();
    }
}
