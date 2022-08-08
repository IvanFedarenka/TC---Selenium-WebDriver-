package com.coherent.task.pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

public class BasePage {

    protected final WebDriver driver;
    protected Logger log
            = (Logger) LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
