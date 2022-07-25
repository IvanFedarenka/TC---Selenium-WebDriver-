package com.coherent.task.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class DriverRunner {

    private WebDriver driver;
    private static DriverRunner driverRunner;

    private DriverRunner() {
    }
    public static DriverRunner getInstance(){
        if(driverRunner==null){
            driverRunner = new DriverRunner();
        }
        return driverRunner;
    }

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        log.info("New web driver instance prepared.");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public WebDriverWait getWaiter(int period){
        return new WebDriverWait(driver, Duration.ofSeconds(period));
    }

    public void close() {
        driver.quit();
    }
}
