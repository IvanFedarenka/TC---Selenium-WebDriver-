package com.coherent.task.utils;

import static com.coherent.task.utils.PropertyManager.getProperty;

public class PropertiesStorage {

    public static final String START_PAGE_URL = getProperty("start_page_url");
    public static final String VALID_LOGIN = getProperty("valid_login");
    public static final String VALID_PASSWORD = getProperty("valid_password");
}
