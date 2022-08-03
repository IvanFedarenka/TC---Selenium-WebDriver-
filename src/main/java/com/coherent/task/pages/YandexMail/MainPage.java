package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class MainPage extends BasePage {

    @FindBy(css = ".NewSettings__icon--1MMbG")
    private WebElement SETTINGS_BUTTON;

    @FindBy(css = "span.user-account__name")
    private WebElement ACCOUNT_NAME;

    @FindBy(xpath = "//img[@class='user-pic__image']")
    private WebElement ACCOUNT_ICON;

    @FindBy(css = "a[aria-label='Log out']")
    private WebElement LOG_OUT;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountNameDisplayed() {
        boolean isNameDisplayed = ACCOUNT_NAME.isDisplayed();
        log.info("Account name " + ACCOUNT_NAME.getText() + " found");
        return isNameDisplayed;
    }

    public boolean isAccountIconDisplayed() {
        boolean isIconDisplayed = ACCOUNT_ICON.isDisplayed();
        log.info("Account name found");
        return isIconDisplayed;
    }

    public boolean isSettingsButtonDisplayed() {
        boolean isButtonDisplayed = SETTINGS_BUTTON.isDisplayed();
        log.info("Settings button found");
        return isButtonDisplayed;
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
