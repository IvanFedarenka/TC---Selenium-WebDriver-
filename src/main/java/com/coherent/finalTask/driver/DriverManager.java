package com.coherent.finalTask.driver;

import com.coherent.finalTask.driver.providers.DockerDriverProvider;
import com.coherent.finalTask.driver.providers.GridDriverProvider;
import com.coherent.finalTask.driver.providers.LocalDriverProvider;
import com.coherent.finalTask.driver.providers.SauceLabsDriverProvider;
import org.openqa.selenium.WebDriver;

import static java.time.Duration.ofSeconds;

public class DriverManager {

    private WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver getDriver(String environment, String browserName) {

        switch (environment) {
            case "local" -> threadLocal.set(new LocalDriverProvider().getDriver(browserName));
            case "grid" -> threadLocal.set(new GridDriverProvider().getDriver(browserName));
            case "sauceLabs" -> threadLocal.set(new SauceLabsDriverProvider().getDriver(browserName));
            case "docker" -> threadLocal.set(new DockerDriverProvider().getDriver(browserName));
        }
        driver = threadLocal.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(30));
        return driver;
    }

    public void tearDown() {
        driver.quit();
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
