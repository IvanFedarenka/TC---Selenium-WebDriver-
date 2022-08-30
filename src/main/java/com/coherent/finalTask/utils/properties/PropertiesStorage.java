package com.coherent.finalTask.utils.properties;

import static com.coherent.finalTask.utils.properties.PropertyManager.*;

public class PropertiesStorage {

    public static final String BASE_URL = getProperty("base.url");
    public static final String EMAIL = getProperty("default.email");
    public static final String PASSWORD = getProperty("default.password");
    public static final String SAUCE_LABS_SERVER_URL = getProperty("sauce_labs_server_url");
    public static final String EXPECTED_TITLE = getProperty("expected.account.page.title");
    public static final String WISHLIST_LOGIN = getProperty("wishlists.test.login");
    public static final String WISHLIST_PASSWORD = getProperty("wishlists.test.password");
    public static final String FAKE_USER_DATA = getProperty("fake.user.data");
    public static final String HUB_URL = getProperty("hub.url");
    public static final String WISHLIST_URL = getProperty("wishlist.url");
}
