package com.coherent.finalTask.driver;

import com.coherent.finalTask.driver.configurations.Browser;
import com.coherent.finalTask.driver.configurations.Environment;
import com.coherent.finalTask.driver.configurations.Platform;
import com.coherent.finalTask.driver.providers.DockerDriverProvider;
import com.coherent.finalTask.driver.providers.GridDriverProvider;
import com.coherent.finalTask.driver.providers.LocalDriverProvider;
import com.coherent.finalTask.driver.providers.SauceLabsDriverProvider;
import org.openqa.selenium.WebDriver;

import static java.time.Duration.ofSeconds;

public class DriverManager {

    private WebDriver driver;

    public WebDriver selectDriver(Environment environment, Browser browserName, Platform platform) {
        switch (environment) {
            case LOCAL -> driver = new LocalDriverProvider().getDriver(browserName);
            case SELENIUM_GRID -> driver = new GridDriverProvider().getDriver(browserName);
            case SAUCE_LABS -> driver = new SauceLabsDriverProvider().getDriver(browserName, platform);
            case DOCKER -> driver = new DockerDriverProvider().getDriver(browserName);
        }
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
