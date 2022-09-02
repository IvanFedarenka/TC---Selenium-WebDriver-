package listeners;

import com.coherent.finalTask.driver.DriverManager;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.lang.reflect.Field;
import java.util.Date;

import static org.openqa.selenium.OutputType.*;

@Slf4j
public class TestListener implements ITestListener {


    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        WebDriver driver = ((BaseTest) instance).getCurrentDriverInstance();

        saveScreenshot(driver);
        attachData(driver);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(BYTES);
    }

    @SneakyThrows
    private void attachData(WebDriver driver) {

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String environment = "OS = " + caps.getPlatformName() + "\n" +
                "Browser.name = " + caps.getBrowserName() + "\n" +
                "Browser.version = " + caps.getBrowserVersion() + "\n" +
                "URL = " + driver.getCurrentUrl() + "\n" +
                "Time: " + new Date();
        Allure.addAttachment("Environment", environment);
    }
}
