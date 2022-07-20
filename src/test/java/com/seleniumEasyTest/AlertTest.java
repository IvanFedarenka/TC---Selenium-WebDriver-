package com.seleniumEasyTest;

import com.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.coherent.task.propertyManager.PropertyManager.*;
import static com.coherent.task.seleniumEasy.locators.AlertLocators.*;
import static org.testng.Assert.*;

public class AlertTest extends BaseTest {

    @BeforeMethod
    public void goTo() {
        driver.get(property("alert_url"));
    }

    @Test
    public void testAcceptConfirmBox() {
        driver.findElement(CONFIRM_BOX_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String expectedMessage = "You pressed OK!";
        assertEquals(expectedMessage, driver.findElement(CONFIRM_BOX_ANSWER_TEXT).getText(), "test accept confirm box failed");
    }

    @Test
    public void testDeclineConfirmBox() {
        driver.findElement(CONFIRM_BOX_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String expectedMessage = "You pressed Cancel!";
        assertEquals(expectedMessage, driver.findElement(CONFIRM_BOX_ANSWER_TEXT).getText(), "test decline confirm box failed");
    }

    @Test
    public void testAlertBox() {
        driver.findElement(PROMPT_BUTTON).click();
        String message = "here is the test message";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
        alert.accept();

        assertTrue(driver.findElement(PROMPT_ANSWER_TEXT).getText().contains(message), "test alert box fail");
    }
}
