package com.wengyingjian.spider;

import com.wengyingjian.spider.components.BossDriver;
import com.wengyingjian.spider.service.HelloService;
import com.wengyingjian.spider.service.LoginService;
import com.wengyingjian.spider.service.SearchService;

/**
 * @author hzwengyingjian
 */
public class Starter {


    public static void main(String[] args) throws InterruptedException {
        //初始化浏览器
        BossDriver.init();

        //登录
        new LoginService().login();

        //筛选查询
        new SearchService().doSearch();

        //打招呼
        for (int i = 1; i < 100; i++) {
            new HelloService().sayHello(i);
        }

        BossDriver.close();
    }

}
