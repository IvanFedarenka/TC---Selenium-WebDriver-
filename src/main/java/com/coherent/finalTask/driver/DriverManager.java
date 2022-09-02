package com.coherent.finalTask.driver;

import com.coherent.finalTask.driver.providers.*;
import org.openqa.selenium.WebDriver;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.ENVIRONMENT;

public class DriverManager {

    private ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    private static volatile DriverManager driverManager;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        DriverManager local = driverManager;
        if (local == null) {
            synchronized (DriverManager.class) {
                local = driverManager;
                if (local == null) {
                    driverManager = local = new DriverManager();
                }
            }
        }
        return local;
    }

    public WebDriver getDriver() {
        IDriverProvider driverProvider;
        switch (ENVIRONMENT) {
            case "local" -> driverProvider = new LocalDriverProvider();
            case "grid" -> driverProvider = new GridDriverProvider();
            case "sauceLabs" -> driverProvider = new SauceLabsDriverProvider();
            case "docker" -> driverProvider = new DockerDriverProvider();
            default -> throw new IllegalStateException("Unexpected value: " + ENVIRONMENT);
        }
        threadLocal.set(driverProvider.getDriver());
        return threadLocal.get();
    }

    public void tearDown() {
        threadLocal.get().quit();
        threadLocal.remove();
    }
}
