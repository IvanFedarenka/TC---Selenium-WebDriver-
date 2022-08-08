package com.coherent.task.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

@Slf4j
public class DriverRunner {

    private WebDriver driver;
    private static DriverRunner driverRunner;

    private DriverRunner() {
    }

    public static synchronized DriverRunner getInstance() {
        if (driverRunner == null) {
            driverRunner = new DriverRunner();
        }
        return driverRunner;
    }

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
        log.info("Web driver instance created");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        return driver;
    }

    public WebDriver getDriverInstance() {
        return driver;
    }

    public void close() {
        driver.close();
    }

    public void quitDriver() {
        driver.quit();
    }
}
