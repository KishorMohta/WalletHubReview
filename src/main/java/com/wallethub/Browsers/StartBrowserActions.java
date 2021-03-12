package com.wallethub.Browsers;

import com.wallethub.actions.HomePage.HomePageActions;
import com.wallethub.actions.Login.LoginActions;
import com.wallethub.actions.Review.ReviewActions;
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
        HomePageActions homePage=new HomePageActions(driver);
        homePage.getHomePageText();
        LoginActions loginActions=new LoginActions(driver);
        loginActions.clickOnLogin().enterEmailAndPassword();
        driver.get(Url);
        ReviewActions reviewActions=new ReviewActions(driver);
        reviewActions.ratingWith4Star();
        return driver;
    }
}
