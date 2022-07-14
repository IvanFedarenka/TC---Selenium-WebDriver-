package com.Coherent.Mail.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverRunner {

    private final WebDriver driver;

    public DriverRunner() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWaiter(int period){
        return new WebDriverWait(driver, Duration.ofSeconds(period));
    }

    public void close() {
        driver.quit();
    }
}
