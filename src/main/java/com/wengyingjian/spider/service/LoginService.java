package com.wengyingjian.spider.service;

import com.wengyingjian.spider.components.BossContext;
import com.wengyingjian.spider.config.BossUrlConstants;
import com.wengyingjian.spider.config.CookieHolder;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public void login() {
        WebDriver driver = BossContext.getWebDriver();
        driver.get(BossUrlConstants.URL_BOSS_RECOMMEND);
        addCookie(driver);
        driver.get(BossUrlConstants.URL_BOSS_RECOMMEND);
    }

    private static void addCookie(WebDriver driver) {
        CookieHolder.getCookieData().forEach(cookie -> {
            driver.manage().addCookie(cookie);
        });
    }
}