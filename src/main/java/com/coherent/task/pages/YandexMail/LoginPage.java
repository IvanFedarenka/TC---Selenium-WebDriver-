package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LoginPage extends BasePage {

    @FindBy(name = "login")
    private WebElement LOGIN_INPUT;

    @FindBy(id = "passp-field-passwd")
    private WebElement PASSWORD_INPUT;

    @FindBy(linkText = "Log in")
    private WebElement START_LOGIN_BUTTON;

    @FindBy(xpath = "//div[@id='field:link-login']/a")
    private WebElement FORGOT_LOGIN_LINK;

    @FindBy(xpath = "//div[@id='field:link-passwd']/a")
    private WebElement FORGOT_PASSWORD_LINK;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sentLogin(String login) {
        LOGIN_INPUT.sendKeys(login);
        log.info("login were sent");
        LOGIN_INPUT.submit();
        return this;
    }

    public MainPage sentPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
        log.info("password were sent");
        PASSWORD_INPUT.submit();
        return new MainPage(driver);
    }

    public boolean isForgotLoginLinkPresented() {
        boolean isLinkDisplayed = FORGOT_LOGIN_LINK.isDisplayed();
        log.info("Link 'forgot login' found");
        return isLinkDisplayed;
    }

    public boolean isForgotPasswordLinkPresented() {
        boolean isLinkDisplayed = FORGOT_PASSWORD_LINK.isDisplayed();
        log.info("Link 'forgot password' found");
        return isLinkDisplayed;
    }
}
