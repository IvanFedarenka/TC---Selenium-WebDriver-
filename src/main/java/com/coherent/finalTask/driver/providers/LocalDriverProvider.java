package com.coherent.finalTask.driver.providers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

@Slf4j
public class LocalDriverProvider implements IDriverProvider {

    public WebDriver getDriver() {
        return switch (System.getProperty("browserName")) {
            case "chrome" -> setChrome();
            case "firefox" -> setFirefox();
            default -> throw new IllegalArgumentException();
        };
    }

    private WebDriver setChrome() {
        return chromedriver().create();
    }

    private WebDriver setFirefox() {
        return firefoxdriver().create();
    }
}
