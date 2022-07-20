package com.seleniumEasyTest;

import com.BaseTest;
import org.testng.annotations.Test;

import static com.coherent.task.propertyManager.PropertyManager.*;
import static com.coherent.task.seleniumEasy.locators.RefreshLocators.*;
import static org.testng.Assert.*;

public class RefreshTest extends BaseTest {

    @Test
    public void testRefresh() {
        driver.get(property("download_url"));
        driver.findElement(START_BUTTON).click();
        while (getProgress() <= 50) {
            continue;
        }
        driver.navigate().refresh();

        assertEquals("0%", driver.findElement(PROGRESS).getText(), "page weren't refreshed");
    }

    private int getProgress() {
        String replace = driver
                .findElement(PROGRESS)
                .getText()
                .replace('%', ' ')
                .trim();
        return Integer.parseInt(replace);
    }
}
