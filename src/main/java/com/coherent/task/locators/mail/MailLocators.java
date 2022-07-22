package com.coherent.task.locators.mail;

import org.openqa.selenium.By;

public class MailLocators {

    public static final By GO_LOGIN_BUTTON = By.xpath("//span[text()='Log in']/..");
    public static final By LOGIN_INPUT = By.name("login");
    public static final By PASSWORD_INPUT = By.id("passp-field-passwd");
    public static final By LOGIN_PAGE_ACCOUNT_NAME = By.cssSelector("span.CurrentAccount-displayName");
    public static final By MAIN_PAGE_ACCOUNT_NAME = By.cssSelector("span.user-account__name");
    public static final By SETTINGS_BUTTON = By.cssSelector(".NewSettings__icon--1MMbG");
    public static final By LOG_OUT_BUTTON = By.xpath("//span[text()='Log out']");

}
