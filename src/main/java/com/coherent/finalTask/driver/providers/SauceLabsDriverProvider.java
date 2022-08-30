package com.coherent.finalTask.driver.providers;

import com.coherent.finalTask.driver.configurations.Browser;
import com.coherent.finalTask.driver.configurations.Platform;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.SAUCE_LABS_SERVER_URL;

public class SauceLabsDriverProvider extends BaseDriverProvider {

    public WebDriver getDriver(Browser name, Platform platform) {
        return switch (name) {
            case CHROME -> createChromeDriver(platform);
            case FIREFOX -> createGeckoDriver(platform);
        };
    }

    @SneakyThrows
    private WebDriver createChromeDriver(Platform platform) {
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<OS - " + platform.getValue() + ">");
        sauceOptions.put("name", "<Browser - " + chromeOptions.getBrowserName() + ">");

        chromeOptions.setBrowserVersion("latest")
                .setPlatformName(platform.getValue())
                .setCapability("sauce:options", sauceOptions);

        URL sauceUrl = new URL(SAUCE_LABS_SERVER_URL);
        threadLocal.set(new RemoteWebDriver(sauceUrl, chromeOptions));
        return threadLocal.get();
    }

    @SneakyThrows
    private WebDriver createGeckoDriver(Platform platform) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<OS - " + platform.getValue() + ">");
        sauceOptions.put("name", "<Browser - " + firefoxOptions.getBrowserName() + ">");

        firefoxOptions.setBrowserVersion("latest")
                .setPlatformName(platform.getValue())
                .setCapability("sauce:options", sauceOptions);

        URL sauceUrl = new URL(SAUCE_LABS_SERVER_URL);
        threadLocal.set(new RemoteWebDriver(sauceUrl, firefoxOptions));
        return threadLocal.get();
    }
}
