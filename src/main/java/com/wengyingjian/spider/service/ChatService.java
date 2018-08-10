package com.wengyingjian.spider.service;

import com.wengyingjian.spider.components.BossDriver;
import org.openqa.selenium.WebElement;

public class ChatService {


    /**
     * 切换到沟通面板
     */
    public ChatService switchTo() throws InterruptedException {
        BossDriver.clickByXpath("//*[@id=\"main\"]/div[1]/div/dl[4]/dt/a");
        Thread.sleep(1000);
        return this;
    }

    /**
     * 指定联系人，选中
     *
     * @param index 序号，第几个人
     */
    public ChatService target(int index) throws InterruptedException {
        BossDriver.scrollAndClickByXpath(getTargetXpath(index), element -> true);
        Thread.sleep(1000);
        return this;
    }

    private String getTargetXpath(int index) {
        return "//*[@id=\"container\"]/div[1]/div[2]/div[3]/div[1]/ul[2]/li[" + index + "]";
    }


    /**
     * 输入聊天内容
     *
     * @param msg 内容
     */
    private ChatService write(String msg) {
        WebElement webElement = BossDriver.findElementByXpath("//*[@id=\"container\"]/div[1]/div[2]/div[4]/div[2]/div[2]/div[2]/div[2]");
        webElement.sendKeys(msg);
        return this;
    }


    /**
     * 发送
     */
    private ChatService send() {
        BossDriver.clickByXpath("//*[@id=\"container\"]/div[1]/div[2]/div[4]/div[2]/div[2]/div[2]/div[3]/button");
        return this;
    }

    public ChatService send(String msg) {
        return write(msg).send();
    }


    /**
     * 发送消息
     *
     * @param index 序号，第几个人
     * @param msgs  内容
     */
    public ChatService send(int index, String... msgs) throws InterruptedException {
        target(index);
        for (String msg : msgs) {
            send(msg);
        }
        return this;
    }
}
