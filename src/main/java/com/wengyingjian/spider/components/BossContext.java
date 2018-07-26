package com.wengyingjian.spider.components;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class BossContext {

    private static final ThreadLocal<WebDriver> context = new ThreadLocal<>();

    public static Properties properties;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        properties = new Properties();
        try {
            properties.load(BossContext.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        Object value = properties.get(key);
        return value == null ? null : String.valueOf(value);
    }

    public static void setWebDriver(WebDriver webDriver) {
        context.set(webDriver);
    }

    public static WebDriver getWebDriver() {
        return context.get();
    }
}
