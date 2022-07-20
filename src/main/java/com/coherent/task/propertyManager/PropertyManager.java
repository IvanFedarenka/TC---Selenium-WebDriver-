package com.coherent.task.propertyManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyManager {

    public static String property(String name) {
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream("src/test/resources/properties/selen.properties"), "UTF-8"));
        } catch (IOException exception) {
            System.out.println("Property file not found!");
            exception.printStackTrace();
        }
        return props.getProperty(name);
    }
}
