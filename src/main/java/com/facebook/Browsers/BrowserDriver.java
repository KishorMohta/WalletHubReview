package com.facebook.Browsers;

import org.openqa.selenium.WebDriver;

public interface BrowserDriver {

    WebDriver getDriver();

    void setPathForDriver();
}

