package com.wengyingjian.spider.config;

import com.wengyingjian.spider.components.BossContext;

public class SeleniumConfigHolder {
    public static final String DRIVER_PATH_KEY = "webdriver.chrome.driver";

    public static String getDriverPath() {
        return BossContext.getProperty(DRIVER_PATH_KEY);
    }
}
