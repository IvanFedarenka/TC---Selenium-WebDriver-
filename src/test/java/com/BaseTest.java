package com;

import com.coherent.task.utils.driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.coherent.task.utils.driverManager.DriverManager.*;

public class BaseTest {

    protected DriverManager driverManager;
    protected WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        driverManager = getInstance();
        driver = driverManager.getDriver();
    }

    @AfterSuite
    public void closeDriver() {
        driverManager.close();
    }
}
