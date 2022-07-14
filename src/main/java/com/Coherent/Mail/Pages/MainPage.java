package com.Coherent.Mail.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage {

    private final WebDriver driver;
    private static final By LIGHT_VERSION_SWITCHER = By.linkText("Light version");
    private static final By ADD_ACCOUNT_BUTTON = By.partialLinkText("an email account");
    private static final By HEADER_LOGO = By.className("PSHeader-Left");
    private static final By BUTTONS = By.tagName("button");
    private static final By SETTINGS_BUTTON = By.cssSelector(".NewSettings__icon--1MMbG");
    private static final By COLLAPSED_MENU = By.xpath("//div[@class='ToggleWidget-Button']/button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLightVersionSwitcher() {
        return driver.findElement(LIGHT_VERSION_SWITCHER);
    }

    public WebElement getHeaderLogo() {
        return driver.findElement(HEADER_LOGO);
    }

    public WebElement getAddAccountButton() {
        return driver.findElement(ADD_ACCOUNT_BUTTON);
    }

    public List<WebElement> getAllButtons() {
        return driver.findElements(BUTTONS);
    }

    public WebElement getSettingsButton() {
        return driver.findElement(SETTINGS_BUTTON);
    }

    public WebElement getCollapsedMenu() {
        return driver.findElement(COLLAPSED_MENU);
    }

    public List<WebElement> getAllElements() {
        return List.of(getCollapsedMenu(), getAddAccountButton(), getSettingsButton(), getHeaderLogo(), getLightVersionSwitcher());
    }
}
