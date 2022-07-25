package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final String BASE_URL = "https://mail.yandex.com";
    private static final By LOGIN_INPUT = By.name("login");
    private static final By PASSWORD_INPUT = By.id("passp-field-passwd");
    private static final By START_LOGIN_BUTTON = By.linkText("Log in");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goTo() {
        driver.get(BASE_URL);
        if (driver.findElement(START_LOGIN_BUTTON).isDisplayed()) {
            driver.findElement(START_LOGIN_BUTTON).click();
        } else return this;
        return this;
    }

    public LoginPage sentLogin(String login) {
        WebElement loginField = driver.findElement(LOGIN_INPUT);
        loginField.sendKeys(login);
        loginField.submit();
        return this;
    }

    public void sentPassword(String password) {
        WebElement passwordField = driver.findElement(PASSWORD_INPUT);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public void logIn(String login, String password) {
        sentLogin(login).sentPassword(password);
    }
}
