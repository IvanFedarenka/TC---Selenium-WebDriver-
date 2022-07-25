package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.coherent.task.utils.PropertiesStorage.*;

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

    public LoginPage goTo() {
        driver.get(LOGIN_PAGE_URL);
        if (START_LOGIN_BUTTON.isDisplayed()) {
            START_LOGIN_BUTTON.click();
        } else return this;
        return this;
    }

    public LoginPage sentLogin(String login) {
        LOGIN_INPUT.sendKeys(login);
        LOGIN_INPUT.submit();
        return this;
    }

    public void sentPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
        PASSWORD_INPUT.submit();
    }

    public void logIn(String login, String password) {
        sentLogin(login).sentPassword(password);
    }
}
