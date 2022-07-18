
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.coherent.mail.locators.Locators.*;
import static com.coherent.mail.util.propertyManager.PropertyManager.*;
import static org.junit.jupiter.api.Assertions.*;

public class MailTest {

    private WebDriver driver;

    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() throws InterruptedException{
        driver.get(getProperty("url"));
        driver.findElement(START_LOGIN_BUTTON).click();
        assertEquals("Authorization", driver.getTitle(), "redirection to the login page");
        driver.findElement(LOGIN_INPUT).sendKeys(getProperty("login"));
        driver.findElement(LOGIN_INPUT).submit();
        Thread.sleep(1000);

        driver.findElement(PASSWORD_INPUT).sendKeys(getProperty("password"));
        driver.findElement(PASSWORD_INPUT).submit();
        Thread.sleep(5000);

        assertAll(
                () -> assertTrue(driver.findElement(SETTINGS_BUTTON).isDisplayed(), "Account's settings button not found"),
                () -> assertTrue(driver.findElement(LIGHT_VERSION_SWITCHER).isDisplayed(), "to the light-version switcher not found"),
                () -> assertTrue(driver.findElement(ADD_ACCOUNT_BUTTON).isDisplayed(), "add account button not found"),
                () -> assertTrue(driver.findElement(HEADER_LOGO).isDisplayed(), "main page logo not found"),
                () -> assertTrue(driver.findElements(BUTTONS).get(0).isDisplayed(), "button not found"),
                () -> assertTrue(driver.findElement(COLLAPSED_MENU).isDisplayed(), "collapsed menu not found")
        );
    }

    @AfterEach
    public void stop() {
        driver.quit();
    }
}
