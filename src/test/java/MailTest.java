
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void testLogin() throws InterruptedException {
        driver.get(BASE_URL);
        driver.findElement(START_LOGIN_BUTTON).click();
        driver.findElement(LOGIN_INPUT).sendKeys(LOGIN);
        driver.findElement(LOGIN_INPUT).submit();
        Thread.sleep(1000);

        driver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        driver.findElement(PASSWORD_INPUT).submit();
        Thread.sleep(5000);

        assertTrue(driver.findElement(SETTINGS_BUTTON).isDisplayed());
    }

    @AfterEach
    public void stop() {
    driver.quit();
    }
}
