package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.*;

public class StartPage extends BasePage {

    @FindBy(linkText = "Log in")
    private WebElement START_LOGIN_BUTTON;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage startLogin() {
        START_LOGIN_BUTTON.click();
        return new LoginPage(driver);
    }
}
