package com.yandexMailTest;

import com.coherent.task.utils.driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Map;

import static com.coherent.task.locators.mail.MailLocators.*;
import static com.coherent.task.utils.driverManager.DriverManager.*;
import static com.coherent.task.utils.common.CommonUtils.*;
import static com.coherent.task.utils.storage.PropertiesStorage.*;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.Assert.assertTrue;

public class LoginMailTest {

    private DriverManager driverManager = getInstance();
    private WebDriver driver;

    @BeforeMethod
    public void start() {
        driver = driverManager.getDriver();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{Map.entry("SeleniumTestUser1", "Selenium_22")},
                new Object[]{Map.entry("SeleniumNewAcc", "SeleniumNewPassword")},
                new Object[]{Map.entry("SeleniumTestUser2", "SeleniumNewPassword2")},
        };
    }

    @Test(dataProvider = "testData",
            description = "Parametrized test login form with three sets of valid credentials," +
                            "explicit waiter, Thread.sleep() usage")
    public void testLogin(Map.Entry<String, String> credentials) {
        driver.get(MAIL_BASE_URL);
        driver.findElement(GO_LOGIN_BUTTON).click();
        driver.findElement(LOGIN_INPUT).sendKeys(credentials.getKey());
        driver.findElement(LOGIN_INPUT).submit();

        driverManager.getWaiter(5)
                .pollingEvery(ofMillis(50))
                .until(visibilityOf(driver.findElement(LOGIN_PAGE_ACCOUNT_NAME)));

        driver.findElement(PASSWORD_INPUT).sendKeys(credentials.getValue());
        driver.findElement(PASSWORD_INPUT).submit();

        pause(4);   // it's kind of an explicit waiter. it acts only once and in exact place

        assertTrue(driver.findElement(MAIN_PAGE_ACCOUNT_NAME).isDisplayed(), "Account name is missing");
        assertTrue(driver.findElement(SETTINGS_BUTTON).isDisplayed(), "Settings button is missing");
    }

    @AfterMethod
    public void exit() {
        driverManager.close();
    }
}
