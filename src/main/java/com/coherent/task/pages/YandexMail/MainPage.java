package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BasePage {

    private static final By SETTINGS_BUTTON = By.cssSelector(".NewSettings__icon--1MMbG");
    private static final By ACCOUNT_NAME = By.cssSelector("span.user-account__name");
    private static final By ACCOUNT_ICON = By.xpath("//div[@class='user-pic user-pic_has-plus_ user-account__pic']/img[@class='user-pic__image']");
    private static final By LOG_OUT = By.cssSelector("a[aria-label='Log out']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountNameDisplayed() {
        boolean isNameVisible = driver.findElement(ACCOUNT_NAME).isDisplayed();
        log.info("Checking visability of Accont name");
        return isNameVisible;
    }

    public boolean isAccountIconDisplayed() {
        boolean isIcoVisible = driver.findElement(ACCOUNT_ICON).isDisplayed();
        log.info("Checking visability of Accont icon");
        return isIcoVisible;
    }

    public boolean isSettingsButtonDisplayed() {
        boolean isButtonVisible = driver.findElement(SETTINGS_BUTTON).isDisplayed();
        log.info("Checking visability of settings button");
        return isButtonVisible;
    }

    public MainPage clickAccountName() {
        driver.findElement(ACCOUNT_NAME).click();
        return this;
    }

    public LoginPage clickLogoutButton() {
        driver.findElement(LOG_OUT).click();
        return new LoginPage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitVisibilityOfAccountName() {
        new WebDriverWait(driver, ofSeconds(7)).until(visibilityOf(driver.findElement(ACCOUNT_NAME)));
    }
}
