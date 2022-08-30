package com.coherent.finalTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class LoginPage extends BasePage {

    private static final By NEW_EMAIL_INPUT = id("email_create");
    private static final By CREATE_ACCOUNT_BUTTON = cssSelector("button#SubmitCreate");
    private static final By EMAIL_INPUT = id("email");
    private static final By PASSWORD_INPUT = id("passwd");
    private static final By SIGN_IN_BUTTON = name("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sentNewEmail(String email) {
        driver.findElement(NEW_EMAIL_INPUT).sendKeys(email);
        return this;
    }

    public RegistrationPage clickCreationButton() {
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new RegistrationPage(driver);
    }

    public LoginPage sentCredentials(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public MyAccountPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new MyAccountPage(driver);
    }
}
