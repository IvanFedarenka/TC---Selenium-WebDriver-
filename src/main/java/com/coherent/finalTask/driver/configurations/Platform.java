package com.coherent.finalTask.driver.configurations;

public enum Platform {
    WINDOWS("Windows 10"),
    MAC("macOS 12");

    private String value;

    Platform(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
