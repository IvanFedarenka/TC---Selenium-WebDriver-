package com.coherent.finalTask.driver.providers;

import com.coherent.finalTask.driver.configurations.Browser;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.HUB_URL;

@Slf4j
public class DockerDriverProvider extends BaseDriverProvider{

    public WebDriver getDriver(Browser browser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser.getValue());

        try {
            threadLocal.set(new RemoteWebDriver(new URL(HUB_URL), caps));
        } catch (MalformedURLException e) {
            log.error("Host error", e);
        }
        return threadLocal.get();
    }
}
