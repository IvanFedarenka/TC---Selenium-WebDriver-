package com.coherent.task.utils.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.*;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager driverManager;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        return driver;
    }

    public WebDriverWait getWaiter(int period) {
        return new WebDriverWait(driver, ofSeconds(period));
    }

    public void close() {
        driver.quit();
    }
}