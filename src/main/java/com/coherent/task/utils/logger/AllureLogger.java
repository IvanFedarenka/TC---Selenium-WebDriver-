package com.coherent.task.utils.logger;

import io.qameta.allure.Step;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.*;
import static java.lang.Thread.*;

public class AllureLogger {

    @Step("{0}")
    public void sentLog(String log) {
    }

    public void info(String message) {
        StackTraceElement[] arr = currentThread().getStackTrace();
        String log = format("%s | %s", buildLog(arr), message);
        sentLog(log);
    }

    private String buildLog(StackTraceElement[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDate()).append(" | ").append(currentThread().getName()).append(" | ").append(" [ ")
                .append(arr[2].getClassName()).append('(').append(arr[2].getMethodName()).append(':')
                .append(arr[2].getLineNumber()).append(']');
        return sb.toString();
    }

    private String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
