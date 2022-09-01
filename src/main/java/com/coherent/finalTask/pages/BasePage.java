package com.coherent.finalTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitVisibilityOf(int seconds, WebElement element) {
        new WebDriverWait(driver, ofSeconds(seconds)).until(visibilityOf(element));
        return element;
    }

    public void waitTitle(int seconds, String title) {
        new WebDriverWait(driver, ofSeconds(seconds)).until(titleIs(title));
    }
}
