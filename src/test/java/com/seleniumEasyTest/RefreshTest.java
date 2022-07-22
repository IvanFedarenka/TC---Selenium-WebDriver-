package com.seleniumEasyTest;

import com.BaseTest;
import org.testng.annotations.Test;

import static com.coherent.task.locators.seleniumEasy.RefreshLocators.*;
import static com.coherent.task.utils.storage.PropertiesStorage.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.*;

public class RefreshTest extends BaseTest {

    @Test (description = "Testing dynamic data loading")
    public void testRefresh() {
        driver.get(DOWNLOAD_BASE_URL);
        driver.findElement(START_BUTTON).click();
        driverManager.getWaiter(20).until(textToBePresentInElement(driver.findElement(PROGRESS), "50%"));
        driver.navigate().refresh();

        assertEquals("0%", driver.findElement(PROGRESS).getText(), "Page weren't refreshed");
    }
}
