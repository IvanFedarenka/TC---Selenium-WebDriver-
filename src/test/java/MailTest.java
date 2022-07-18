
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;

import static com.coherent.mail.locators.Locators.*;
import static org.junit.jupiter.api.Assertions.*;

public class MailTest {

    private WebDriver driver;

    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() throws InterruptedException, IOException {
        driver.get(getProperty("URL"));
        driver.findElement(START_LOGIN_BUTTON).click();
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

    private String getProperty(String name) throws IOException {
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("src/main/resources/properties/selen.properties"), "UTF-8"));
        return props.getProperty(name);
    }

    @AfterEach
    public void stop() {
        driver.quit();
    }
}
