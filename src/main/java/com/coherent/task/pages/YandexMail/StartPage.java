package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(linkText = "Log in")
    private WebElement goToLoginButton;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage startLogin() {
        goToLoginButton.click();
        return new LoginPage(driver);
    }
}
