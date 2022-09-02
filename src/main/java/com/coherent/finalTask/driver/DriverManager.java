package com.coherent.finalTask.driver;

import com.coherent.finalTask.driver.providers.*;
import org.openqa.selenium.WebDriver;

import static java.time.Duration.ofSeconds;

public class DriverManager {

    private IDriverProvider driverProvider;
    private WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {

        switch (System.getProperty("environment")) {
            case "local" -> driverProvider = new LocalDriverProvider();
            case "grid" -> driverProvider = new GridDriverProvider();
            case "sauceLabs" -> driverProvider = new SauceLabsDriverProvider();
            case "docker" -> driverProvider = new DockerDriverProvider();
        }
        threadLocal.set(driverProvider.getDriver());
        driver = threadLocal.get();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(30));
        return driver;
    }

    public void tearDown() {
        driver.quit();
        threadLocal.remove();
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
