package com.wengyingjian.spider.config;

import com.wengyingjian.spider.components.BossContext;
import org.openqa.selenium.Cookie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CookieHolder {

    public static String BOSS_COOKIE_KEY = "boss.cookie";

    public static List<Cookie> getCookieData() {
        String cookieStrs = BossContext.getProperty(BOSS_COOKIE_KEY);
        List<String> cookies = Arrays.asList(cookieStrs.split("; "));
        return cookies.stream().map(cookieStr -> {
            String[] cookieSplit = cookieStr.split("=");
            return new Cookie(cookieSplit[0], cookieSplit[1]);
        }).collect(Collectors.toList());
    }
}
