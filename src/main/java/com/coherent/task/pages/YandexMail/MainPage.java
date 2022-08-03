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
    private WebElement settingButton;

    @FindBy(css = "span.user-account__name")
    private WebElement accountName;

    @FindBy(xpath = "//img[@class='user-pic__image']")
    private WebElement accountIcon;

    @FindBy(css = "a[aria-label='Log out']")
    private WebElement LogOutLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountNameDisplayed() {
        boolean isNameDisplayed = accountName.isDisplayed();
        log.info("Account name " + accountName.getText() + " found");
        return isNameDisplayed;
    }

    public boolean isAccountIconDisplayed() {
        boolean isIconDisplayed = accountIcon.isDisplayed();
        log.info("Account name found");
        return isIconDisplayed;
    }

    public boolean isSettingsButtonDisplayed() {
        boolean isButtonDisplayed = settingButton.isDisplayed();
        log.info("Settings button found");
        return isButtonDisplayed;
    }

    public MainPage clickAccountName() {
        accountName.click();
        return this;
    }

    public LoginPage clickLogoutButton() {
        LogOutLink.click();
        return new LoginPage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitVisibilityOfAccountName() {
        new WebDriverWait(driver, ofSeconds(7)).until(visibilityOf(accountName));
    }

}
