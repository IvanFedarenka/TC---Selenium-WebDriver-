package com.seleniumEasyTest;

import com.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.coherent.task.locators.seleniumEasy.AlertLocators.*;
import static com.coherent.task.utils.storage.PropertiesStorage.*;
import static org.testng.Assert.*;

public class AlertTest extends BaseTest {

    private static final String CONFIRM_EXPECTED_MESSAGE = "You pressed OK!";
    private static final String DECLINE_EXPECTED_MESSAGE = "You pressed Cancel!";
    private static final String ALERT_BOX_TEST_MESSAGE = "here is the test message";


    @BeforeMethod
    public void goTo() {
        driver.get(ALERT_BASE_URL);
    }

    @Test(description = "Testing confirm box functional through Accept")
    public void testAcceptConfirmBox() {
        driver.findElement(CONFIRM_BOX_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        assertEquals(CONFIRM_EXPECTED_MESSAGE, driver.findElement(CONFIRM_BOX_ANSWER_TEXT).getText(), "Test accept confirm box failed");
    }

    @Test(description = "Testing confirm box functional through Decline")
    public void testDeclineConfirmBox() {
        driver.findElement(CONFIRM_BOX_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        assertEquals(DECLINE_EXPECTED_MESSAGE, driver.findElement(CONFIRM_BOX_ANSWER_TEXT).getText(), "Test decline confirm box failed");
    }

    @Test(description = "Testing alert box functional< sending message in it")
    public void testAlertBox() {
        driver.findElement(PROMPT_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(ALERT_BOX_TEST_MESSAGE);
        alert.accept();

        assertTrue(driver.findElement(PROMPT_ANSWER_TEXT).getText().contains(ALERT_BOX_TEST_MESSAGE), "Test alert box fail");
    }
}
