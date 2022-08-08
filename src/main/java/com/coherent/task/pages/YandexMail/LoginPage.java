package com.coherent.task.pages.YandexMail;

import com.beust.ah.A;
import com.coherent.task.pages.BasePage;
import com.coherent.task.utils.logger.AllureLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final By LOGIN_INPUT = By.name("login");
    private static final By PASSWORD_INPUT = By.id("passp-field-passwd");
    private static final By FORGOT_LOGIN_LINK = By.xpath("//div[@id='field:link-login']/a");
    private static final By FORGOT_PASSWORD_LINK = By.xpath("//div[@id='field:link-passwd']/a");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private AllureLogger log = new AllureLogger();

    public LoginPage sentLogin(String login) {
        WebElement loginField = driver.findElement(LOGIN_INPUT);
        loginField.sendKeys(login);
        loginField.submit();
        return this;
    }

    public MainPage sentPassword(String password) {
        WebElement passwordField = driver.findElement(PASSWORD_INPUT);
        passwordField.sendKeys(password);
        passwordField.submit();
        return new MainPage(driver);
    }

    public boolean isForgotLoginLinkPresented() {
        boolean isLinkVisible = driver.findElement(FORGOT_LOGIN_LINK).isDisplayed();
        log.info("Checking visability of 'forgot login link'");
        return isLinkVisible;
    }

    public boolean isForgotPasswordLinkPresented() {
        boolean isLinkVisible = driver.findElement(FORGOT_PASSWORD_LINK).isDisplayed();
        log.info("Checking visability of 'forgot password link'");
        return isLinkVisible;
    }
}
