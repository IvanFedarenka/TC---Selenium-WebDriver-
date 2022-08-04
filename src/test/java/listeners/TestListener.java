package listeners;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        Object driver = null;
        try {
            Field driverField = instance.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            driver = driverField.get(instance);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.error("Failed while making screenshot", e);
        }

        saveScreenshot((WebDriver) driver);
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        saveLogs("Browser name: " + caps.getBrowserName());
        saveLogs("Browser version: " + caps.getBrowserVersion());
        saveLogs("OS: " + caps.getPlatformName() + " " + caps.getPlatformName().getMajorVersion());
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Info", type = "text/plain")
    public String saveLogs(String message) {
        return message;
    }
}
