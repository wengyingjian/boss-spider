package com.wengyingjian.spider;

import com.wengyingjian.spider.components.BossDriver;
import com.wengyingjian.spider.service.ChatService;
import com.wengyingjian.spider.service.HelloService;
import com.wengyingjian.spider.service.LoginService;
import com.wengyingjian.spider.service.SearchService;

public class ChatTest {

    public static void main(String[] args) throws InterruptedException {
        //初始化浏览器
        BossDriver.init();

        //登录
        new LoginService().login();

        new ChatService().switchTo().send(1, "你好", "简历已收到");

        BossDriver.close();
    }
}
