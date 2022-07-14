package com.Coherent.Mail.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private static final String BASE_URL = "https://mail.yandex.com";
    private static final String LOGIN = "SeleniumTestUser1";
    private static final String PASSWORD = "Selenium_22";
    private static final By LOGIN_INPUT = By.name("login");
    private static final By PASSWORD_INPUT = By.id("passp-field-passwd");


    public LoginPage openMainPage(){
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Log in")).click();
        return this;
    }
    public void login(){
        WebElement loginField = driver.findElement(LOGIN_INPUT);
        loginField.sendKeys(LOGIN);
        loginField.submit();

        WebElement passwordField = driver.findElement(PASSWORD_INPUT);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
    }
}
