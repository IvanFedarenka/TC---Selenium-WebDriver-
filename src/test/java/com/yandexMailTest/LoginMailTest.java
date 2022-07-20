package com.yandexMailTest;

import com.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Map;

import static com.coherent.task.mail.locators.MailLocators.*;
import static com.coherent.task.propertyManager.PropertyManager.*;
import static java.time.Duration.*;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.Assert.assertTrue;

public class LoginMailTest extends BaseTest {

    @BeforeMethod
    public void start() {
        driver.manage().deleteAllCookies();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{Map.entry("SeleniumTestUser1", "Selenium_22")},
                new Object[]{Map.entry("SeleniumNewAcc", "SeleniumNewPassword")},
                new Object[]{Map.entry("SeleniumTestUser2", "SeleniumNewPassword2")},
        };
    }

    @Test(dataProvider = "testData")
    public void testLogin(Map.Entry<String, String> credentials) throws InterruptedException {
        driver.get(property("mail_url"));
        driver.findElement(GO_LOGIN_BUTTON).click();
        driver.findElement(LOGIN_INPUT).sendKeys(credentials.getKey());
        driver.findElement(LOGIN_INPUT).submit();

        new WebDriverWait(driver, ofSeconds(5))
                .pollingEvery(ofMillis(50))
                .until(visibilityOf(driver.findElement(LOGIN_PAGE_ACCOUNT_NAME)));

        driver.findElement(PASSWORD_INPUT).sendKeys(credentials.getValue());
        driver.findElement(PASSWORD_INPUT).submit();

        Thread.sleep(6000);   // it's kind of an explicit waiter. it acts only once and in exact place

        assertTrue(driver.findElement(MAIN_PAGE_ACCOUNT_NAME).isDisplayed(), "account name is missing");
        assertTrue(driver.findElement(SETTINGS_BUTTON).isDisplayed(), "settings button is missing");
    }

    @AfterMethod
    public void exit() {
        driver.findElement(MAIN_PAGE_ACCOUNT_NAME).click();
        driver.findElement(LOG_OUT_BUTTON).click();
    }
}
