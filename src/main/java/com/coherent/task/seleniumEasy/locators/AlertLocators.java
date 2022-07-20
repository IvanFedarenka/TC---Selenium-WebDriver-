package com.coherent.task.seleniumEasy.locators;

import org.openqa.selenium.By;

public class AlertLocators {

    public static final By CONFIRM_BOX_BUTTON = By.xpath("//div[text()='Java Script Confirm Box']/..//button");
    public static final By CONFIRM_BOX_ANSWER_TEXT = By.cssSelector("p#confirm-demo");
    public static final By PROMPT_BUTTON = By.xpath("//button[text()='Click for Prompt Box']");
    public static final By PROMPT_ANSWER_TEXT = By.cssSelector("p#prompt-demo");
}
