package com.facebook.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageHandler {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageHandler(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public static void waitForPageLoad(WebDriver driver) {
        waitForDomLoad(driver);

        int count = 0;
        while (true) {
            sleep(1000L);
            count++;

            if (count == 120) {
                System.out.println("Page Not Loaded in 2 minutes.");
            }
            WebElement loadPercent = driver.findElement(By.className("progressBar"));
            String loadAttr = loadPercent.getAttribute("style");
            if (StringUtils.isBlank(loadAttr) || StringUtils.contains(loadAttr, "opacity: 0")) {
                break;
            }
        }
        sleep(5 * 1000L);
    }

    public static void sleep(Long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Interrupt occured.");
        }
    }

    public static void waitForDomLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals(
                        "complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(pageLoadCondition);
    }

    public static String selectDropdownValueContains(WebElement options, String text) {
        Select dropDown = new Select(options);
        int index = 0;
        String selectedText = "";
        for (WebElement option : dropDown.getOptions()) {
            selectedText = option.getText();
            if (StringUtils.containsIgnoreCase(selectedText, text)) {
                dropDown.selectByIndex(index);
                return StringUtils.trimToEmpty(selectedText);
            }
            index++;
        }
        return null;
    }

    public void selectFromDropDown(WebElement element, int value) {
        click(element);
        Select dropDown = new Select(element);
        dropDown.selectByIndex(value);
    }

    public void selectFromDropDown(WebElement element, String value) {
        javaScriptExecuterClick(element);
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    public void mouseOver(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void javaScriptExecuterClick(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public void jSExecuterScrolldown(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
    }

    protected void clickAndWaitForPageLoad(WebElement element) {
        click(element);
        waitForPageToLoad();
    }

    protected void waitForPageToLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    protected void waitForPageToLoad(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void clickAndSendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected void waitForelementToBeVisisble(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
}
