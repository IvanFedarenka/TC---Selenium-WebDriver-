package com.coherent.finalTask.driver.providers;

import org.openqa.selenium.WebDriver;

public class BaseDriverProvider {

    protected static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

}
