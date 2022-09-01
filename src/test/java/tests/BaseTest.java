package tests;

import com.coherent.finalTask.driver.DriverManager;
import com.coherent.finalTask.pages.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.coherent.finalTask.config.SetSystemProperties.*;
import static com.coherent.finalTask.utils.properties.PropertiesStorage.*;

@Slf4j
public class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager = new DriverManager();

    @BeforeClass
    public void setDriver() {
        this.driver = driverManager.getDriver(ENVIRONMENT, BROWSER_NAME);
        log.info("Driver instance created, test started");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("Current driver instance closed.");
        attachEnvironment(driver);
    }

    @BeforeSuite
    public void setProps() {
        setProperties();
    }

    protected LoginPage openLoginPage() {
        driver.get(BASE_URL);
        return new LoginPage(driver);
    }

    public void attachEnvironment(WebDriver driver) {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String environment = "OS = " + caps.getPlatformName() + "\n" +
                "Browser.name = " + caps.getBrowserName() + "\n" +
                "Browser.version = " + caps.getBrowserVersion() + "\n";

        File env = new File("target/allure-results/environment.properties");
        try {
            FileOutputStream outputStream = new FileOutputStream(env);
            outputStream.write(environment.getBytes());
        } catch (IOException e) {
            log.error("Unsuccess while writing the environment file", e);
        }
    }

    public WebDriver getCurrentDriverInstance() {
        return driver;
    }
}
