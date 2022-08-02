package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {

    private static final String BASE_URL = "https://mail.yandex.com";
    private static final By START_LOGIN_BUTTON = By.linkText("Log in");

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public StartPage goToStartPage() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage startLogin() {
        driver.findElement(START_LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }
}
