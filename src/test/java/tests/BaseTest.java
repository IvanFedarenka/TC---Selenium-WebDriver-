package tests;

import ch.qos.logback.classic.Logger;
import com.coherent.finalTask.driver.DriverManager;
import com.coherent.finalTask.pages.LoginPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.coherent.finalTask.driver.configurations.Browser.*;
import static com.coherent.finalTask.driver.configurations.Environment.*;
import static com.coherent.finalTask.driver.configurations.Platform.*;
import static com.coherent.finalTask.utils.properties.PropertiesStorage.*;

public class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager = new DriverManager();
    protected Logger log
            = (Logger) LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setDriver() {
        this.driver = driverManager.selectDriver(SAUCE_LABS, FIREFOX, WINDOWS);
        log.info("Driver instance created, test started");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("Current driver instance closed.");
        attachEnvironment(driver);
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
