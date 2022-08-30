package com.coherent.finalTask.driver.configurations;

public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox");

    private String value;

    Browser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
