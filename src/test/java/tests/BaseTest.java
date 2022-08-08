package tests;

import ch.qos.logback.classic.Logger;
import com.coherent.task.driver.DriverRunner;
import com.coherent.task.pages.YandexMail.StartPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.coherent.task.driver.DriverRunner.getInstance;
import static com.coherent.task.utils.properties.PropertiesStorage.START_PAGE_URL;


public class BaseTest {

    protected DriverRunner driverRunner = getInstance();
    protected WebDriver driver;
    protected Logger log
            = (Logger) LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void initDriver() {
        driver = driverRunner.getDriver();
        log.info("Test just started, driver initialized");
    }

    @AfterMethod
    public void close() {
        driverRunner.close();
        log.info("Test just finished, driver instance closed");
    }

    public StartPage openStartPage() {
        driver.get(START_PAGE_URL);
        log.info("Start page was opened");
        return new StartPage(driver);
    }
}
