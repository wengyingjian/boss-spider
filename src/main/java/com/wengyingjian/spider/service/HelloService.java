package com.wengyingjian.spider.service;

import com.wengyingjian.spider.components.BossDriver;

public class HelloService {

    /**
     * 打招呼
     *
     * @param index 序号，第几个人
     */
    public void sayHello(int index) throws InterruptedException {
        BossDriver.scrollAndClickByXpath(getSayHelloXpath(index), element -> element.getText().contains("打招呼"));
        Thread.sleep(1000);
    }


    private String getSayHelloXpath(int index) {
        return "//*[@id=\"recommend-list\"]/div[1]/ul/li[" + index + "]/div[1]/button";
    }


}
