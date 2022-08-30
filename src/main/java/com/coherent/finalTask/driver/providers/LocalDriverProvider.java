package com.coherent.finalTask.driver.providers;

import com.coherent.finalTask.driver.configurations.Browser;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Slf4j
public class LocalDriverProvider extends BaseDriverProvider {

    public WebDriver getDriver(Browser name) {
        return switch (name) {
            case CHROME -> setChrome();
            case FIREFOX -> setFirefox();
        };
    }

    private WebDriver setChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webDriver/chromedriver.exe");
        threadLocal.set(new ChromeDriver());
        log.info("Chrome driver instance created");
        return threadLocal.get();
    }

    private WebDriver setFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/webDriver/geckodriver.exe");
        threadLocal.set(new FirefoxDriver());
        log.info("Firefox driver instance created");
        return threadLocal.get();
    }
}
