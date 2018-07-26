package com.wengyingjian.spider.components;

import com.wengyingjian.spider.config.SeleniumConfigHolder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BossDriver {

    static {
        System.setProperty(SeleniumConfigHolder.DRIVER_PATH_KEY, SeleniumConfigHolder.getDriverPath());
    }

    public static void init() {
        WebDriver webDriver = new ChromeDriver();
        BossContext.setWebDriver(webDriver);
    }

    public static void close(){
        BossContext.getWebDriver().close();
    }

    public static WebElement findElement(By by) {
        try {
            return BossContext.getWebDriver().findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static void clickByXpath(String xpath) {
        clickByXpath(xpath, false, element -> true);
    }


    public static void scrollAndClickByXpath(String xpath, Function function) {
        clickByXpath(xpath, true, function);
    }

    private static void clickByXpath(String xpath, boolean scroll, Function function) {
        WebElement element = findElement(By.xpath(xpath));
        //按钮不存在
        if (element == null) {
            return;
        }
        //滚动
        if (scroll) {
            ((JavascriptExecutor) BossContext.getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
        }
        //点击
        if (function.click(element)) {
            element.click();
        }
    }


    public interface Function {
        boolean click(WebElement element);
    }
}
