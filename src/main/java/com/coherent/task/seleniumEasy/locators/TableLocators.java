package com.coherent.task.seleniumEasy.locators;

import org.openqa.selenium.By;

public class TableLocators {

    public static final By TABLE = By.xpath("//table/tbody");
    public static final By NEXT_BUTTON = By.cssSelector("a#example_next");
    public static final By SELECT_NUM_OF_ENTRIES = By.xpath("//select[@name='example_length']");
}
