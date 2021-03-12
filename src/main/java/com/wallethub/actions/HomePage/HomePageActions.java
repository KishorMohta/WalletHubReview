package com.wallethub.actions.HomePage;

import com.wallethub.Assertion.homePageAssertions;
import com.wallethub.utils.Loggers;
import com.wallethub.utils.PageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageActions extends PageHandler {
    private String expectedQuote;

    @FindBy(css = "h1.profile-name")
    private WebElement getHomePageText;

    public HomePageActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePageActions getHomePageText() {
        expectedQuote = getHomePageText.getText();
        Loggers.info("Assert home page == ", expectedQuote);
        homePageAssertions.quoteAssertions(expectedQuote);
        return new HomePageActions(driver);
    }

}
