package com.coherent.mail.locators;

import org.openqa.selenium.By;

public class Locators {

    public static final By LOGIN_INPUT = By.name("login");
    public static final By PASSWORD_INPUT = By.id("passp-field-passwd");

    public static final By START_LOGIN_BUTTON = By.xpath("//span[text()='Log in']/..");
    public static final By SETTINGS_BUTTON = By.cssSelector(".NewSettings__icon--1MMbG");
    public static final By LIGHT_VERSION_SWITCHER = By.linkText("Light version");
    public static final By ADD_ACCOUNT_BUTTON = By.partialLinkText("an email account");
    public static final By HEADER_LOGO = By.className("PSHeader-Left");
    public static final By BUTTONS = By.tagName("button");
    public static final By COLLAPSED_MENU = By.xpath("//div[@class='ToggleWidget-Button']/button");

}
