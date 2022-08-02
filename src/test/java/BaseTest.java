import com.coherent.task.driver.DriverRunner;
import com.coherent.task.pages.YandexMail.StartPage;
import com.coherent.task.utils.PropertiesStorage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.coherent.task.driver.DriverRunner.*;
import static com.coherent.task.utils.PropertiesStorage.*;

public class BaseTest {

    protected DriverRunner driverRunner = getInstance();
    protected WebDriver driver;
    protected StartPage startPage;

    @BeforeMethod
    public void initDriver() {
        driver = driverRunner.getDriver();
        startPage = PageFactory.initElements(driver, StartPage.class);
        openStartPage();
    }

    @AfterMethod
    public void close() {
        driverRunner.close();
    }

    public StartPage openStartPage() {
        driver.get(START_PAGE_URL);
        return startPage;
    }
}
