package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;


    @BeforeSuite
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }

}
