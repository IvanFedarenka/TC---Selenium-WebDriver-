package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LoginPage extends BasePage {

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordInput;

    @FindBy(linkText = "Log in")
    private WebElement startLoginButton;

    @FindBy(xpath = "//div[@id='field:link-login']/a")
    private WebElement forgotLoginButton;

    @FindBy(xpath = "//div[@id='field:link-passwd']/a")
    private WebElement forgotPasswordButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sentLogin(String login) {
        loginInput.sendKeys(login);
        log.info("login were sent");
        loginInput.submit();
        return this;
    }

    public MainPage sentPassword(String password) {
        passwordInput.sendKeys(password);
        log.info("password were sent");
        passwordInput.submit();
        return new MainPage(driver);
    }

    public boolean isForgotLoginLinkPresented() {
        boolean isLinkDisplayed = forgotLoginButton.isDisplayed();
        log.info("Link 'forgot login' found");
        return isLinkDisplayed;
    }

    public boolean isForgotPasswordLinkPresented() {
        boolean isLinkDisplayed = forgotPasswordButton.isDisplayed();
        log.info("Link 'forgot password' found");
        return isLinkDisplayed;
    }
}
