package tests;

import com.coherent.task.driver.DriverRunner;
import com.coherent.task.pages.YandexMail.StartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.coherent.task.driver.DriverRunner.getInstance;
import static com.coherent.task.utils.properties.PropertiesStorage.START_PAGE_URL;

public class BaseTest {

    protected DriverRunner driverRunner = getInstance();
    protected WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = driverRunner.getDriver();
    }

    @AfterMethod
    public void close() {
        driverRunner.close();
    }

    public StartPage openStartPage() {
        driver.get(START_PAGE_URL);
        return new StartPage(driver);
    }
}
