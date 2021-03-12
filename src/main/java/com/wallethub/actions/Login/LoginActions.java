package com.wallethub.actions.Login;

import com.wallethub.utils.PageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginActions extends PageHandler {

    private final String loginId = "mohta.kishor97@gmail.com";
    private final String password = "Km@123456";

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    private WebElement emailId;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement login;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement enterPassword;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement clickLogin;

    public LoginActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginActions clickOnLogin() {
        waitForPageToLoad();
        click(login);
        return new LoginActions(driver);
    }

    public LoginActions enterEmailAndPassword() {
        waitForPageToLoad();
        clickAndSendKeys(emailId, loginId);
        clickAndSendKeys(enterPassword, password);
            click(login);
        return new LoginActions(driver);

    }
}
