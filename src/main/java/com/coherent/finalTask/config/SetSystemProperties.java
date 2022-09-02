package com.coherent.finalTask.config;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class SetSystemProperties {

    private static final String PROPERTIES_PATH = "src/test/resources/myProperties.txt";

    @SneakyThrows
    public static void setProperties(){

        FileInputStream propFile = new FileInputStream(PROPERTIES_PATH);
        Properties properties = new Properties(System.getProperties());
        properties.load(propFile);
        System.setProperties(properties);
    }
}
