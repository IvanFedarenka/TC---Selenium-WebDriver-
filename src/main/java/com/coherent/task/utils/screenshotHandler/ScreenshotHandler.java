package com.coherent.task.utils.screenshotHandler;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ScreenshotHandler {

    public void makeShot(WebDriver driver, String path) {
        TakesScreenshot shot = (TakesScreenshot) driver;
        File screenFile = shot.getScreenshotAs(OutputType.FILE);
        File resultFile = new File(path);
        try {
            FileHandler.copy(screenFile, resultFile);
            log.info("Login page Screenshot captured");
        } catch (IOException e) {
            log.error("Failed writing screenshot to the file", e);
        }
    }
}
