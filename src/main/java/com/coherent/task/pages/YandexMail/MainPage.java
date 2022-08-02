package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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

    public boolean isAccountNameDisplayed() {
        return ACCOUNT_NAME.isDisplayed();
    }

    public boolean isAccountIconDisplayed() {
        return ACCOUNT_ICON.isDisplayed();
    }

    public boolean isSettingsButtonDisplayed() {
        return SETTINGS_BUTTON.isDisplayed();
    }

    public MainPage clickAccountName() {
        ACCOUNT_NAME.click();
        return this;
    }

    public LoginPage clickLogoutButton() {
        LOG_OUT.click();
        return new LoginPage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitVisibilityOfAccountName() {
        new WebDriverWait(driver, ofSeconds(7)).until(visibilityOf(ACCOUNT_NAME));
    }

}
