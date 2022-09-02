package com.coherent.finalTask.driver.providers;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.HUB_URL;

@Slf4j
public class DockerDriverProvider implements IDriverProvider {

    @SneakyThrows
    public WebDriver getDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(System.getProperty("browserName"));
        return new RemoteWebDriver(new URL(HUB_URL), caps);
    }
}
