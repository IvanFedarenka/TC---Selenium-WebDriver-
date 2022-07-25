package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    private static final By SETTINGS_BUTTON = By.cssSelector(".NewSettings__icon--1MMbG");
    private static final By ACCOUNT_NAME = By.cssSelector("span.user-account__name");
    private static final By ACCOUNT_ICON = By.xpath("//div[@class='user-pic user-pic_has-plus_ user-account__pic']/img[@class='user-pic__image']");
    private static final By LOG_OUT = By.cssSelector("a[aria-label='Log out']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAccountName() {
        return driver.findElement(ACCOUNT_NAME);
    }

    public WebElement getAccountIcon() {
        return driver.findElement(ACCOUNT_ICON);
    }

    public WebElement getSettingsButton() {
        return driver.findElement(SETTINGS_BUTTON);
    }

    public WebElement getLogoutButton() {
        return driver.findElement(LOG_OUT);
    }

}
