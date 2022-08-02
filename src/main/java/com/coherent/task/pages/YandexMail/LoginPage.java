package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.*;

public class LoginPage extends BasePage {

    @FindBy(name = "login")
    private WebElement LOGIN_INPUT;

    @FindBy(id = "passp-field-passwd")
    private WebElement PASSWORD_INPUT;

    @FindBy(linkText = "Log in")
    private WebElement START_LOGIN_BUTTON;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sentLogin(String login) {
        LOGIN_INPUT.sendKeys(login);
        LOGIN_INPUT.submit();
        return this;
    }

    public MainPage sentPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
        PASSWORD_INPUT.submit();
        return initElements(driver, MainPage.class);
    }

    public MainPage logIn(String login, String password) {
        return initElements(driver, StartPage.class)
                .goToStartPage().startLogin()
                .sentLogin(login).sentPassword(password);
    }
}
