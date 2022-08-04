package com.coherent.task.utils.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

@Slf4j
public class PropertyManager {

    private static final String PROPS_PATH = "src/test/resources/testData.properties";

    public static String getProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream(PROPS_PATH), "UTF-8"));
        } catch (IOException exception) {
            log.error("Properties not found", exception);
        }
        return props.getProperty(name);
    }
}
