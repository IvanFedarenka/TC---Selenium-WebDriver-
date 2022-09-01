package com.coherent.finalTask.driver.providers;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.SAUCE_LABS_SERVER_URL;

public class SauceLabsDriverProvider {

    public WebDriver getDriver(String name) {
        return switch (name) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createGeckoDriver();
            default -> throw new IllegalArgumentException();
        };
    }

    @SneakyThrows
    private WebDriver createChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<OS - Windows 10>");
        sauceOptions.put("name", "<Browser - " + chromeOptions.getBrowserName() + ">");

        chromeOptions.setBrowserVersion("latest")
                .setPlatformName("Windows 10")
                .setCapability("sauce:options", sauceOptions);

        URL sauceUrl = new URL(SAUCE_LABS_SERVER_URL);
        return new RemoteWebDriver(sauceUrl, chromeOptions);
    }

    @SneakyThrows
    private WebDriver createGeckoDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<OS - Windows 10>");
        sauceOptions.put("name", "<Browser - " + firefoxOptions.getBrowserName() + ">");

        firefoxOptions.setBrowserVersion("latest")
                .setPlatformName("Windows 10")
                .setCapability("sauce:options", sauceOptions);

        URL sauceUrl = new URL(SAUCE_LABS_SERVER_URL);
        return new RemoteWebDriver(sauceUrl, firefoxOptions);
    }
}
