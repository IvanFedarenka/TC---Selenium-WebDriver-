package com.coherent.task.seleniumEasy.locators;

import org.openqa.selenium.By;

public class SelectLocators {

    public static final By MULTI_SELECT_LIST = By.xpath("//select[@name='States']");
    public static final By LIST_ELEMENTS = By.xpath("//select[@name='States']/option");
    public static final By PRINT_ALL_BUTTON = By.xpath("//button[text()='Get All Selected']");
    public static final By SELECTED_ITEMS_LINE = By.cssSelector("p.getall-selected");
}
