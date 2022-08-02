package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final By LOGIN_INPUT = By.name("login");
    private static final By PASSWORD_INPUT = By.id("passp-field-passwd");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

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

    public MainPage logIn(String login, String password) {
        return new StartPage(driver)
                .goToStartPage().startLogin()
                .sentLogin(login).sentPassword(password);
    }
}
