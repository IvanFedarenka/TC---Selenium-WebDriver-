package com.coherent.task.utils.common;

import com.coherent.task.utils.logger.LogManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class CommonUtils extends LogManager {

    private static final String PROPERTY_PATH = "src/test/resources/properties/selen.properties";

    public static String property(String name) {
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream(PROPERTY_PATH), "UTF-8"));
        } catch (IOException exception) {
            log.error("Property file not found!", exception);
        }
        return props.getProperty(name);
    }

    public static void pause(int n) {
        try {
            Thread.sleep(n * 1000L);
        } catch (InterruptedException e) {
            log.error("Thread sleep error", e);
        }
    }
}
