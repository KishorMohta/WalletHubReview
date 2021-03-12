package com.wallethub.actions.Review;

import com.wallethub.utils.PageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewActions extends PageHandler {
    @FindBy(xpath = "//div[@class='rv review-action ng-enter-element']//div[@class='rating-box-wrapper']")
    private WebElement hoverToStar;

    public ReviewActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ReviewActions ratingWith4Star() {

        jSExecuterScrolldown(hoverToStar);
        javaScriptExecuterClick();
//        List<WebElement> webDriver= driver.findElements(By.xpath("//div[@class='rv review-action ng-enter-element']//div[@class='rating-box-wrapper']"));
//        System.out.println(webDriver.size());
//        mouseOver(webDriver.get(4));

//        mouseOver(hoverToStar);
        return new ReviewActions(driver);
    }
}
