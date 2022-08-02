package com.coherent.task.pages.YandexMail;

import com.coherent.task.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {

    private static final String BASE_URL = "https://mail.yandex.com";
    @FindBy(linkText = "Log in")
    private WebElement START_LOGIN_BUTTON;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public StartPage goToStartPage() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage startLogin() {
        START_LOGIN_BUTTON.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
