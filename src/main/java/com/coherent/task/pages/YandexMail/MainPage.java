package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = ".NewSettings__icon--1MMbG")
    private WebElement SETTINGS_BUTTON;

    @FindBy(css = "span.user-account__name")
    private WebElement ACCOUNT_NAME;

    @FindBy(xpath = "//div[@class='user-pic user-pic_has-plus_ user-account__pic']/img[@class='user-pic__image']")
    private WebElement ACCOUNT_ICON;

    @FindBy(css = "a[aria-label='Log out']")
    private WebElement LOG_OUT;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAccountName() {
        return ACCOUNT_NAME;
    }

    public WebElement getAccountIcon() {
        return ACCOUNT_ICON;
    }

    public WebElement getSettingsButton() {
        return SETTINGS_BUTTON;
    }

    public WebElement getLogoutButton() {
        return LOG_OUT;
    }

}
