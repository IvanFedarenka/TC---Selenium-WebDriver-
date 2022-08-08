package listeners;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.spi.LogbackLock;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.util.Date;

import static com.coherent.task.driver.DriverRunner.*;
import static com.google.common.hash.Hashing.md5;
import static io.qameta.allure.Allure.*;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        WebDriver driver = getInstance().getDriverInstance();
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String environment = "OS = " + caps.getPlatformName() + "\n" +
                "Browser.name = " + caps.getBrowserName() + "\n" +
                "Browser.version = " + caps.getBrowserVersion() + "\n" +
                "URL = https://mail.yandex.com";

        File env = new File("target/allure-results/environment.properties");
        try {
            FileOutputStream outputStream = new FileOutputStream(env);
            outputStream.write(environment.getBytes());
        } catch (IOException e) {
            log.error("Unsuccess while writing the environment file", e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = getInstance().getDriverInstance();
        saveScreenshot(driver);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
